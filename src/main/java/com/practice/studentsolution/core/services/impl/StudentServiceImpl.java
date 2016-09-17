package com.practice.studentsolution.core.services.impl;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;
import com.practice.studentsolution.core.entities.Student;
import com.practice.studentsolution.core.repositories.StudentRepository;
import com.practice.studentsolution.core.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by amerida on 9/15/2016.
 */

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public List<Student> findBy(String field, String value) {
        return studentRepository.findBy(field, value);
    }

    @Override
    public List<Student> findByTypeAndGender(StudentType studentType, Gender gender) {
        return studentRepository.findByTypeAndGender(studentType, gender);
    }
}
