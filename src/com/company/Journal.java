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

    public void addGroupToJournal(String dataInput) {
        Group newGroup = new Group();
        newGroup.setNameOfGroup(dataInput);
        this.groups.add(newGroup);
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

    public void addRatingByStudent() {
        outListOfGroups();
        int groupNumber = getGroupNumberFromKeyboard();
        int studentNumber = getStudentNumberFromKeyboardByGroup(groupNumber);
        int subjectNumber = getSubjectNumberFromKeyboard();
        Rating rating = new Rating();
        rating.setSubject(subjects.get(subjectNumber));
        System.out.print("Set rating ");
        rating.setRating(Integer.parseInt(inputFromKeyboard()));
        groups.get(groupNumber).getListOfStudents().get(studentNumber).getRatingsOfStudent().add(rating);
    }

    public void addRatingsToGroupBySubject() {
        int subjectNumber = getSubjectNumberFromKeyboard();
        int groupNumber = getGroupNumberFromKeyboard();
        System.out.println("Subject " + subjects.get(subjectNumber).getName() + " - Group " + groups.get(groupNumber).getNameOfGroup());
        Rating rating = new Rating();
        rating.setSubject(subjects.get(subjectNumber));
        List<Student> students = groups.get(groupNumber).getListOfStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.print(student + " ");
            rating.setRating(Integer.parseInt(inputFromKeyboard()));
            student.getRatingsOfStudent().add(rating);
        }
    }

    public void addSubjectToJournal(String nameOfSubject) {
        Subject subject = new Subject();
        subject.setName(nameOfSubject);
        subjects.add(subject);
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
        outListOfStudent(groupNumber);
        int studentNumber = 0;
        studentNumber = Integer.parseInt(inputFromKeyboard()) - 1;
        return studentNumber;
    }

    public void outListOfGroups() {
        for (int i = 0; i < groups.size(); i++) {
            System.out.println((i + 1) + ". " + groups.get(i).getNameOfGroup());
        }
    }

    public void outListOfStudent(int numberOfGroup) {
        List<Student> students = groups.get(numberOfGroup).getListOfStudents();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student);
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

    public void outListOfSubjects() {
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }
    }

    public void outListOfRatings() {
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
