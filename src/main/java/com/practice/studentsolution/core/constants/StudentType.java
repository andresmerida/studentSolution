package com.practice.studentsolution.core.constants;

/**
 * Created by amerida on 9/15/2016.
 */
public enum StudentType {
    KINDER,
    ELEMENTARY,
    HIGH,
    UNIVERSITY;

    private static final StudentType[] ENUMS = StudentType.values();

    /**
     * @param type should be {Kinder, Elementary, High, University}
     * @return StudentType, not null
     */
    public static StudentType of(String type) {
        StudentType res = null;
        for (StudentType studentType : ENUMS) {
            if (studentType.toString().equalsIgnoreCase(type)) {
                res = studentType;
            }
        }
        return res;
    }
}
