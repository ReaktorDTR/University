package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */

public class Group implements Serializable {
    private String nameOfGroup;
    private List<Student> listOfStudents = new ArrayList<>();

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public void addStudentToGroup(Student student) {
        if (!this.listOfStudents.contains(student)) {
            this.listOfStudents.add(student);
        }
    }

    public void removeStudentFromGroup(Student student) {
        listOfStudents.remove(listOfStudents.indexOf(student));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (listOfStudents != null ? !listOfStudents.equals(group.listOfStudents) : group.listOfStudents != null)
            return false;
        if (nameOfGroup != null ? !nameOfGroup.equals(group.nameOfGroup) : group.nameOfGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nameOfGroup != null ? nameOfGroup.hashCode() : 0;
        result = 31 * result + (listOfStudents != null ? listOfStudents.hashCode() : 0);
        return result;
    }
}
