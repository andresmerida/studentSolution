package com.practice.studentsolution.core.repositories;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;
import com.practice.studentsolution.core.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by amerida on 9/15/2016.
 */

@Repository
public class StudentRepository {

    private final static Logger log = Logger.getLogger(StudentRepository.class.getName());

    LinkedList<Student> students;

    public StudentRepository() {
        students = new LinkedList<>();
    }

    /*
    * get all students sorted by last updated date
    */
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>(students);
        Collections.sort(allStudents, Collections.reverseOrder());
        return allStudents;
    }

    public Student add(Student student) {
        students.add(student);
        return student;
    }

    public void delete(Student student) {
        students.remove(student);
    }

    /*
    * find students by a field
    */
    public List<Student> findBy(String field, String value) {
        List<Student> resStudentList = new ArrayList<>();
        boolean orderByName = false;

        switch (field) {
            case "name": // find by name
                for (Student student : students) {
                    if (student.getName().equalsIgnoreCase(value)) {
                        resStudentList.add(student);
                    }
                }
                orderByName = true;
                break;

            case "gender": // find by gender
                for (Student student : students) {
                    if (student.getGender().toString().equalsIgnoreCase(value)) {
                        resStudentList.add(student);
                    }
                }
                break;

            case "type": // find by student type
                for (Student student : students) {
                    if (student.getType().toString().equalsIgnoreCase(value)) {
                        resStudentList.add(student);
                    }
                }

                break;
        }

        if (orderByName) {
            resStudentList.stream().sorted((s1, s2) -> s2.getName()
                    .compareTo(s1.getName())).collect(Collectors.toList()); // sort alphabetically
        } else {
            Collections.sort(resStudentList, Collections.reverseOrder()); // order by last update desc
        }
        return resStudentList;
    }

    /*
    * find by type and gender
    */
    public List<Student> findByTypeAndGender(StudentType studentType, Gender gender) {
        List<Student> resStudentList = new ArrayList<>();
        for (Student student : students) {
            if (studentType == student.getType() && gender == student.getGender()) {
                resStudentList.add(student);
            }
        }
        Collections.sort(resStudentList, Collections.reverseOrder()); // order by last update desc

        return resStudentList;
    }
}
