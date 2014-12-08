package com.company;

import java.util.Date;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Student {
    private String name;
    private String lastName;

    public Student(String name, String lastName, int group, int course) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!lastName.equals(student.lastName)) return false;
        if (!name.equals(student.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
