package com.company;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Rating {
    private Student student;
    private Lesson lesson;
    private int rating;

    public Rating(Student student, Lesson lesson, int rating) {
        this.student = student;
        this.lesson = lesson;
        this.rating = rating;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating1 = (Rating) o;

        if (rating != rating1.rating) return false;
        if (!lesson.equals(rating1.lesson)) return false;
        if (!student.equals(rating1.student)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = student.hashCode();
        result = 31 * result + lesson.hashCode();
        result = 31 * result + rating;
        return result;
    }
}
