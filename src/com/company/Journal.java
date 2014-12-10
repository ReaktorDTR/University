package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */

public class Journal implements Serializable {
    private List<Group> groups = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    public void addGroupToJournal(String nameOfGroup) {
        if (Validation.validateNameOfGroup(nameOfGroup)) {
            Group newGroup = new Group();
            newGroup.setNameOfGroup(nameOfGroup);
            if (!this.groups.contains(newGroup)) {
                this.groups.add(newGroup);
            }
        } else {
            System.out.println("Bad input");
        }

    }

    public void removeGroupFromJournal() {
        System.out.println("Select group to remove");
        removeGroupFromJournal(getGroupNumberFromKeyboard());
    }

    public void removeGroupFromJournal(int groupNumber) {
        groups.remove(groupNumber);
    }

    public void addSubjectToJournal(String nameOfSubject) {
        if (Validation.validateNameOFSubject(nameOfSubject)) {
            Subject newSubject = new Subject();
            newSubject.setName(nameOfSubject);
            if (!this.subjects.contains(newSubject)) {
                this.subjects.add(newSubject);
            }
        } else {
            System.out.println("Bad data");
        }
    }

    public void removeSubjectFromJournal() {
        System.out.println("Select subject to remove");
        removeSubjectFromJournal(getSubjectNumberFromKeyboard());
    }

    public void removeSubjectFromJournal(int subjectNumber) {
        subjects.remove(subjectNumber);
    }

    public void addStudentToGroup() {
        int groupNumber = getGroupNumberFromKeyboard();
        System.out.println("Add student (Name and LastName)");
        String inputData = inputFromKeyboard();
        String[] studentData = inputData.split(" ");
        groups.get(groupNumber).addStudentToGroup(new Student(studentData[0], studentData[1]));
    }

    public void addStudentsToGroup() {
        int groupNumber = getGroupNumberFromKeyboard();
        System.out.println("Add students (Name and LastName),  E - exit");
        while (true) {
            String inputData = inputFromKeyboard();
            if (inputData.equals("E")) break;
            String[] studentData = inputData.split(" ");
            groups.get(groupNumber).addStudentToGroup(new Student(studentData[0], studentData[1]));
        }
    }

    public void removeStudentFromGroup() {
        int groupNumber = getGroupNumberFromKeyboard();
        int studentNumber = getStudentNumberFromKeyboardByGroup(groupNumber);
        Student student = groups.get(groupNumber).getListOfStudents().get(studentNumber);
        groups.get(groupNumber).removeStudentFromGroup(student);
    }

    public void addRatingToStudent() {
        int groupNumber = getGroupNumberFromKeyboard();
        int studentNumber = getStudentNumberFromKeyboardByGroup(groupNumber);
        int subjectNumber = getSubjectNumberFromKeyboard();
        Rating rating = new Rating();
        rating.setSubject(subjects.get(subjectNumber));
        System.out.print("Set rating ");
        rating.setMark(Integer.parseInt(inputFromKeyboard()));
        groups.get(groupNumber).getListOfStudents().get(studentNumber).addRating(rating);
    }

    public void removeRatingFromStudent() {
        int groupNumber = getGroupNumberFromKeyboard();
        int studentNumber = getStudentNumberFromKeyboardByGroup(groupNumber);
        outListOfRatingsByStudent(groupNumber, studentNumber);
        int ratingNumber = 0;
        ratingNumber = Integer.parseInt(inputFromKeyboard()) - 1;
        Rating rating = groups.get(groupNumber).getListOfStudents().get(studentNumber).getRatingsOfStudent().get(ratingNumber);
        groups.get(groupNumber).getListOfStudents().get(studentNumber).removeRating(rating);
    }

    public void addRatingsToGroupBySubject() {
        int subjectNumber = getSubjectNumberFromKeyboard();
        int groupNumber = getGroupNumberFromKeyboard();
        System.out.println("Subject " + subjects.get(subjectNumber).getName() + " - Group " + groups.get(groupNumber).getNameOfGroup());
        List<Student> students = groups.get(groupNumber).getListOfStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.print(student + " ");
            Rating rating = new Rating();
            rating.setSubject(subjects.get(subjectNumber));
            rating.setMark(Integer.parseInt(inputFromKeyboard()));
            student.addRating(rating);
        }
    }

    private int getSubjectNumberFromKeyboard() {
        outListOfSubjects();
        int subjectNumber = 0;
        subjectNumber = Integer.parseInt(inputFromKeyboard()) - 1;
        return subjectNumber;
    }

    private int getGroupNumberFromKeyboard() {
        outListOfGroups();
        int groupNumber = 0;
        groupNumber = Integer.parseInt(inputFromKeyboard()) - 1;
        return groupNumber;
    }

    private int getStudentNumberFromKeyboardByGroup(int groupNumber) {
        outListOfStudentsByGroup(groupNumber);
        int studentNumber = 0;
        studentNumber = Integer.parseInt(inputFromKeyboard()) - 1;
        return studentNumber;
    }

    public void outListOfGroups() {
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i).getNameOfGroup());
        }
    }

    public void outListOfStudents() {
        for (Group group : groups) {
            System.out.println("Group: " + group.getNameOfGroup());
            for (Student student : group.getListOfStudents()) {
                System.out.println(" " + student);
            }
        }
    }

    public void outListOfStudentsByGroup(int groupNumber) {
        List<Student> students = groups.get(groupNumber).getListOfStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student);
        }
    }

    public void outListOfRatingsByStudent(int groupNumber, int studentNumber) {
        List<Rating> ratings = groups.get(groupNumber).getListOfStudents().get(studentNumber).getRatingsOfStudent();
        for (int i = 0; i < ratings.size(); i++) {
            Rating rating = ratings.get(i);
            System.out.println((i + 1) + ". " + rating);
        }
    }

    public void outListOfSubjects() {
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }
    }

    public void outListOfRatingsAllStudents() {
        for (Group group : groups) {
            System.out.println("Group: " + group.getNameOfGroup());
            for (Student student : group.getListOfStudents()) {
                System.out.println(" " + student);
                for (Rating rating : student.getRatingsOfStudent()) {
                    System.out.println("  " + rating);
                }
            }
        }
    }

    public static String inputFromKeyboard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputData = reader.readLine();
            return inputData;
        } catch (IOException e) {
            System.out.println("Bad data");
            e.printStackTrace();
        }
        return "";
    }
}
