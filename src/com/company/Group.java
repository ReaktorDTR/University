package com.company;

import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Group {
    private String nameOfGroup;
    private List<Student> listOfStudents;

    public Group(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public Group(String nameOfGroup, List<Student> students) {
        this.nameOfGroup = nameOfGroup;
        this.listOfStudents = students;
    }

    public void addStudentToGroup(Student student) {
        listOfStudents.add(student);
    }

    public Student findStudent(String name, String lastName) {
        for (Student student : listOfStudents) {
            if (student.equals(student)) {
                return student;
            }
        }
        return null;
    }
}
