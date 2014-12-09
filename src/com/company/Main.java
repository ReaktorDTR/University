package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Journal journal = new Journal();
/*        journal.addGroupToJournal("Programmer");
        journal.addGroupToJournal("Tech");
        journal.addStudentToGroup("Serhii Dovhaniuk Programmer");
        journal.addStudentToGroup("Lilya Doruna Programmer");
        journal.addStudentToGroup("Anton Deryabin Tech");
        journal.addStudentToGroup("Tanya Zabrin Tech");
        journal.addRatingToJournal("Serhii Dovhaniuk Programmer Math 5");
        journal.addRatingToJournal("Serhii Dovhaniuk Programmer Economy 2");
        journal.addRatingToJournal("Tanya Zabrin Tech Math 4");
        journal.addRatingToJournal("Tanya Zabrin Tech Biology 5");*/
        String inputData = "";
        while (!inputData.equals("E")) {
            System.out.print("key : ");
            inputData = inputFromKeyboard();
            if (inputData.equals("AG")) {
                journal.addGroupToJournal(inputFromKeyboard());
            } else if (inputData.equals("AS")) {
                System.out.println("n ls gr");
                journal.addStudentToGroup(inputFromKeyboard());
            } else if (inputData.equals("LS")) {
                journal.outListOfStudents();
            } else if (inputData.equals("LR")) {
                journal.outListOfRatings();
            } else if (inputData.equals("AR")) {
                System.out.println("n ls gr sub r");
                journal.addRatingToJournal(inputFromKeyboard());
            } else if (inputData.equals("CJ")) {
                journal = null;
            } else if (inputData.equals("SJ")) {
                journalToFile(journal);
            } else if (inputData.equals("LJ")) {
                journal = journalFromFile();
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
