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
}
