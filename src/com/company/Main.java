package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Journal journal = new Journal();
        List <Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson("computer science", 90));
        lessons.add(new Lesson("mathematics", 120));

        List <Student> students = new ArrayList<>();
        students.add(new Student("Serhii", "Dovhaniuk", 101, 1));
        students.add(new Student("Anton", "Deryabin", 101, 1));
        students.add(new Student("Lilya", "Doruna", 102, 2));
        students.add(new Student("Tanyu", "Zabrin", 102, 2));



        journal.setRatingToStudent(students.get(0));

    }
}
