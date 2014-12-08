package com.company;

/**
 * Created by nromanen on 12/8/2014.
 */
public class Lesson {
    private String nameOfLesson;
    private int countHourOfYear;

    public Lesson(String nameOfLesson, int countHourOfYear) {
        this.nameOfLesson = nameOfLesson;
        this.countHourOfYear = countHourOfYear;
    }

    public String getName() {
        return nameOfLesson;
    }

    public void setName(String nameOfLesson) {
        this.nameOfLesson = nameOfLesson;
    }

    public int getCountHourOfYear() {
        return countHourOfYear;
    }

    public void setCountHourOfYear(int countHourOfYear) {
        this.countHourOfYear = countHourOfYear;
    }
}
