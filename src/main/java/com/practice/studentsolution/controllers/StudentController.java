package com.practice.studentsolution.controllers;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;
import com.practice.studentsolution.core.entities.Student;
import com.practice.studentsolution.core.services.StudentService;
import com.practice.studentsolution.core.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by amerida on 9/15/2016.
 */

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void createStudent(Student student) {
        studentService.createStudent(student);
    }

    public List<Student> getStudents(String[] parameters) throws IllegalArgumentException {
        if (parameters.length == 0) { // no criteria, get all students
            return studentService.getAllStudents();

        } else if (parameters.length == 1) { // find by one criteria
            String[] parameter = parameters[0].split(CommonUtil.EQUALITY_SYMBOL);
            return studentService.findBy(parameter[0], parameter[1]);

        } else { // TODO, in this case I'm assuming that the value is type and gender by time. It cam be improved
            String[] typeParameter = parameters[0].split(CommonUtil.EQUALITY_SYMBOL);
            String[] genderParameter = parameters[1].split(CommonUtil.EQUALITY_SYMBOL);

            return studentService.findByTypeAndGender(StudentType.of(typeParameter[1]),
                    Gender.of(genderParameter[1].charAt(0)));

        }
    }
}
