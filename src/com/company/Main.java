package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Journal journal = new Journal();
        journal.addGroupToJournal("Programmer");
        journal.addGroupToJournal("Tech");
        journal.addSubjectToJournal("Tech");
        journal.addSubjectToJournal("Math");
        String inputData = "";
        while (!inputData.equals("E")) {
            System.out.print("key : ");
            inputData = inputFromKeyboard();
            if (inputData.equals("AG")) {
                journal.addGroupToJournal(inputFromKeyboard());
            } else if (inputData.equals("ASTG")) {
                journal.addStudentsToGroup();
            } else if (inputData.equals("LS")) {
                journal.outListOfStudents();
            } else if (inputData.equals("LR")) {
                journal.outListOfRatings();
            } else if (inputData.equals("AS")) {
                journal.addSubjectToJournal(inputFromKeyboard());
            } else if (inputData.equals("ARBS")) {
                journal.addRatingByStudent();
            } else if (inputData.equals("ARTGBS")) {
                journal.addRatingsToGroupBySubject();
            } else if (inputData.equals("CJ")) {
                journal = null;
            } else if (inputData.equals("SJ")) {
                journalToFile(journal);
            } else if (inputData.equals("LJ")) {
                journal = journalFromFile();
            } else if (inputData.equals("H")) {
                System.out.println("AG, ASTG, ARBS, ARTGBS, LS, LR, CJ, SJ, LJ, E, H");
            }
        }
    }

    public static String inputFromKeyboard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputData = reader.readLine();
            return inputData;
        } catch (IOException e) {
            System.out.println("Bad data");
            e.printStackTrace();
        }
        return "";
    }

    public static void journalToFile(Journal journal) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("testBase.dat"))) {
            outputStream.writeObject(journal);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Journal journalFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("testBase.dat"))) {
            return (Journal) inputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
