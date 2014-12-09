package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Journal implements Serializable {
    private List<Group> groups = new ArrayList<>();

    public void addGroupToJournal(String dataInput) {
        Group newGroup = new Group();
        newGroup.setNameOfGroup(dataInput);
        this.groups.add(newGroup);
    }

    public void addStudentToGroup(String dataInput) {
        String[] studentData = dataInput.split(" ");
        if (studentData.length == 3) {
            String nameOfStudent = studentData[0];
            String lastNameOfStudent = studentData[1];
            String nameOfGroup = studentData[2];
            Group group = new Group();
            for (Group elementListGroups : this.groups) {
                if (nameOfGroup.equals(elementListGroups.getNameOfGroup())) {
                    group = elementListGroups;
                }
            }
            group.addStudentToGroup(new Student(nameOfStudent, lastNameOfStudent));
        }
    }

    private Student getStudentFromGroups(String nameOfStudent, String lastNameOfStudent, String nameOfGroup) {
        for (Group group : this.groups) {
            if (nameOfGroup.equals(group.getNameOfGroup())) {
                return group.getStudentFromGroup(nameOfStudent, lastNameOfStudent);
            }
        }
        return null;
    }

    public void addRatingToJournal(String dataInput) {
        String[] studentData = dataInput.split(" ");
        if (studentData.length == 5) {
            String nameOfStudent = studentData[0];
            String lastNameOfStudent = studentData[1];
            String nameOfGroup = studentData[2];
            Student student;
            student = this.getStudentFromGroups(nameOfStudent, lastNameOfStudent, nameOfGroup);
            if (student != null) {

                String nameOfSubject = studentData[3];
                int inputtedRating = 0;
                try {
                    inputtedRating = Integer.parseInt(studentData[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input");
                }
                Subject subject = new Subject();
                subject.setName(nameOfSubject);
                Rating rating = new Rating();
                rating.setSubject(subject);
                rating.setRating(inputtedRating);
                student.addRating(rating);
            }
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

    public void outListOfRatings() {
        for (Group group : groups) {
            System.out.println("Group: " + group.getNameOfGroup());
            for (Student student : group.getListOfStudents()) {
                System.out.println(" " + student);
                for (Rating rating : student.getRatings()) {
                    System.out.println("  " + rating);
                }
            }
        }
    }
}
