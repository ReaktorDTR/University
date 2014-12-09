package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Student implements Serializable {
    private String name;
    private String lastName;
    private List<Rating> ratingsOfStudent = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Rating> getRatingsOfStudent() {
        return ratingsOfStudent;
    }

    public void setRatingsOfStudent(List<Rating> ratingsOfStudent) {
        this.ratingsOfStudent = ratingsOfStudent;
    }

    public void addRating(Rating rating) {
        this.ratingsOfStudent.add(rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName() + " " + getLastName();
    }
}
