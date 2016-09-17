package com.practice.studentsolution;

import com.practice.studentsolution.controllers.StudentController;
import com.practice.studentsolution.core.entities.Student;
import com.practice.studentsolution.core.repositories.StudentRepository;
import com.practice.studentsolution.core.utils.SingleInstanceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by amerida on 9/15/2016.
 */

@SpringBootApplication
public class StudentSolution implements CommandLineRunner {

    private final static Logger log = Logger.getLogger(StudentSolution.class.getName());
    private final static String ERROR_MESSAGE = "Argument error, try with these lines of command: \n " +
            "java StudentSolution input.csv name=Leia \n " +
            "java StudentSolution input.csv type=Kinder \n " +
            "java StudentSolution input.csv gender=F \n " +
            "java StudentSolution input.csv gender=F type=Kinder \n";

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentController studentController;

    public static void main(String[] args) {
        SpringApplication.run(StudentSolution.class, args);
    }

    @Override
    public void run(String... args) {

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(args[0]).getFile());

            if (args.length > 0 && file.exists()) { // a little arguments validations
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        Student student = SingleInstanceStudent.getInstance().getInstanceStudent(scanner.nextLine());
                        if (student != null) {
                            studentController.createStudent(student);
                        }
                    }
                    scanner.close();
                }
                log.info("Students loaded");

                // found students by rules or criteria
                log.info("Start find students by criteria");
                for (Student student : studentController.getStudents(Arrays.copyOfRange(args, 1, args.length))) {
                    System.out.println(student.toString());
                }

                log.info("End Process");
            } else {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.print(ERROR_MESSAGE);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
