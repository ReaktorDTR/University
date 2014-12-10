package com.company;

import java.io.Serializable;

/**
 * Created by nromanen on 12/8/2014.
 */

public class Subject implements Serializable {
    private String nameOfSubject;

    public String getName() {
        return nameOfSubject;
    }

    public void setName(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    @Override
    public String toString() {
        return this.nameOfSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (nameOfSubject != null ? !nameOfSubject.equals(subject.nameOfSubject) : subject.nameOfSubject != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nameOfSubject != null ? nameOfSubject.hashCode() : 0;
    }
}
