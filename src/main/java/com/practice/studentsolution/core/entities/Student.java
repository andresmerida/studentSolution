package com.practice.studentsolution.core.entities;

import com.practice.studentsolution.core.constants.Gender;
import com.practice.studentsolution.core.constants.StudentType;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by amerida on 9/15/2016.
 */
public class Student implements Comparable<Student> {

    private StudentType type;
    private String name;
    private Gender gender;
    private Date updated;

    public Student() {
    }

    public StudentType getType() {
        return type;
    }

    public void setType(StudentType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public int compareTo(Student student) {
        return getUpdated().compareTo(student.getUpdated());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (type != student.type) return false;
        if (!name.equals(student.name)) return false;
        if (gender != student.gender) return false;
        return updated.equals(student.updated);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + updated.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "type=" + type.toString() +
                ", name='" + name + '\'' +
                ", gender=" + gender.toString() +
                ", updated=" + new Timestamp(updated.getTime()) +
                '}';
    }
}
