package com.practice.studentsolution.core.services;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;
import com.practice.studentsolution.core.entities.Student;

import java.util.List;

/**
 * Created by amerida on 9/15/2016.
 */

public interface StudentService {
    Student createStudent(Student student);

    void removeStudent(Student student);

    List<Student> getAllStudents();

    List<Student> findBy(String field, String value);

    List<Student> findByTypeAndGender(StudentType studentType, Gender gender);
}
