package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Group implements Serializable {
    private String nameOfGroup;

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    private List<Student> listOfStudents = new ArrayList<>();

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public void addStudentToGroup(Student student) {
        this.listOfStudents.add(student);
    }

    public Student getStudentFromGroup(String nameOfStudent, String lastNameOfStudent) {
        Student student = new Student(nameOfStudent, lastNameOfStudent);
        for (Student elementStudent : listOfStudents) {
            if (student.equals(elementStudent)) {
                return elementStudent;
            }
        }
        return null;
    }
}
