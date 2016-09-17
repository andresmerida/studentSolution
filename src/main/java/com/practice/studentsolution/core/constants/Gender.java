package com.practice.studentsolution.core.constants;

/**
 * Created by amerida on 9/15/2016.
 */
public enum Gender {
    MALE('M'),
    FEMALE('F');

    private final Character gender;

    Gender(Character gender) {
        this.gender = gender;
    }

    /**
     * @param inputGender should be F OR M
     * @return gender, not null
     */
    public static Gender of(Character inputGender) {
        if (inputGender == Gender.FEMALE.getGender()) {
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }

    /**
     * get gender value
     */
    public Character getGender() {
        return gender;
    }
}
