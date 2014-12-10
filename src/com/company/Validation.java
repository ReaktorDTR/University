package com.company;

/**
 * Created by sdovhtc on 12/10/2014.
 */

public class Validation {

    private static final String GROUP_PATTERN = "^[A-Z0-9][a-z0-9]+(-[A-Z0-9]{0,1}[a-z0-9]+)*$";
    private static final String SUBJECT_PATTERN = "^[A-Z][a-z]+(-[A-Z]{0,1}[a-z]+)*$";
    private static final String FIRST_NAME_PATTERN = "^[A-Z][a-z]+$";
    private static final String LAST_NAME_PATTERN = "^[A-Z][a-z]+(-[A-Z][a-z]+)*$";
    private static final String MARK_PATTERN = "^[1-5]$";

    public static boolean validateFirstName(String firstName) {
        return firstName.matches(FIRST_NAME_PATTERN);
    }

    public static boolean validateLastName(String lastName) {
        return lastName.matches(LAST_NAME_PATTERN);
    }

    public static boolean validateNameOFSubject(String subject) {
        return subject.matches(SUBJECT_PATTERN);
    }

    public static boolean validateNameOfGroup(String group) {
        return group.matches(GROUP_PATTERN);
    }

    public static boolean validateMark(String mark) {
        return mark.matches(MARK_PATTERN);
    }



}
