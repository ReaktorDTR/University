package com.company;

import java.io.Serializable;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Rating implements Serializable {
    private Subject subject;
    private int rating;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return getSubject() + " " + String.valueOf(getRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (rating != rating1.rating) return false;
        if (subject != null ? !subject.equals(rating1.subject) : rating1.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + rating;
        return result;
    }
}
