package com.practice.studentsolution.core.utils;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;
import com.practice.studentsolution.core.entities.Student;

/**
 * Created by amerida on 9/15/2016.
 */
public class SingleInstanceStudent {

    //create an object of SingleCreateStudent
    private static SingleInstanceStudent instance = new SingleInstanceStudent();

    private static final String DEFAULT_DELIMITER = ",";

    //make the constructor private so that this class cannot be
    //instantiated
    private SingleInstanceStudent() {
    }

    //Get the only object available
    public static SingleInstanceStudent getInstance() {
        return instance;
    }

    public Student getInstanceStudent(String line) {
        String[] dataStudent = line.split(DEFAULT_DELIMITER);
        if (dataStudent.length == 4) {
            Student student = new Student();
            switch (dataStudent[0]) {
                case "Kinder":
                    student.setType(StudentType.KINDER);
                    break;
                case "Elementary":
                    student.setType(StudentType.ELEMENTARY);
                    break;
                case "High":
                    student.setType(StudentType.HIGH);
                    break;
                case "University":
                    student.setType(StudentType.UNIVERSITY);
                    break;
                default:
                    return null;
            }
            student.setName(dataStudent[1]);
            student.setGender(Gender.of(dataStudent[2].charAt(0)));
            student.setUpdated(DateUtil.getDateYyyyMMddHHmmssFormat(dataStudent[3]));

            return student;
        } else {
            return null;
        }

    }

    public String getDefaultDelimiter() {
        return DEFAULT_DELIMITER;
    }
}
