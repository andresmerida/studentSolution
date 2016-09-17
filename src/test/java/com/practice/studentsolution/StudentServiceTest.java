package com.practice.studentsolution;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;
import com.practice.studentsolution.core.entities.Student;
import com.practice.studentsolution.core.services.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by amerida on 9/15/2016.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StudentSolution.class)
public class StudentServiceTest {

    public static final String NAME = "name";

    @Autowired
    private StudentService studentService;

    @Test
    public void createTest() {
        Student student = buildStudent();
        int size = studentService.getAllStudents().size();
        studentService.createStudent(student);
        Assert.assertEquals(size + 1, studentService.getAllStudents().size());
    }

    @Test
    public void getAllStudentsTest() {
        Student studentM = buildStudent();
        Student studentF = buildStudent();
        studentF.setGender(Gender.FEMALE);
        int size = studentService.getAllStudents().size();
        studentService.createStudent(studentM);
        studentService.createStudent(studentF);
        Assert.assertEquals(size + 2, studentService.getAllStudents().size());
    }

    @Test
    public void findByTest() {
        Student excludeStudent = buildStudent();
        int size = studentService.findBy(NAME, "testName").size();
        studentService.createStudent(excludeStudent);
        Assert.assertEquals(size, studentService.findBy(NAME, "testName").size());
    }

    @Test
    public void removeTest() {
        Student student = studentService.createStudent(buildStudent());
        int size = studentService.getAllStudents().size();
        studentService.removeStudent(student);
        Assert.assertEquals(size - 1, studentService.getAllStudents().size());
    }

    private Student buildStudent() {
        Student s = new Student();
        s.setGender(Gender.MALE);
        s.setName("John");
        s.setType(StudentType.UNIVERSITY);
        return s;
    }
}
