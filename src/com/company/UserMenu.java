package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Reaktor on 10.12.2014.
 */
public class UserMenu {
    private static Journal journal = new Journal();
    private static IOJournal ioJournal = new IOJournal();

    public static void showMenu() {
        String inputData = "";
        while (!inputData.equals("E")) {
            System.out.print("key : ");
            inputData = inputFromKeyboard();
            if (inputData.equals("AG")) {
                journal.addGroupToJournal(inputFromKeyboard());
            } else if (inputData.equals("RG")) {
                journal.removeGroupFromJournal();
            } else if (inputData.equals("AS")) {
                journal.addSubjectToJournal(inputFromKeyboard());
            } else if (inputData.equals("RS")) {
                journal.removeSubjectFromJournal();
            } else if (inputData.equals("ASTG")) {
                journal.addStudentsToGroup();
            } else if (inputData.equals("AOSTG")) {
                journal.addStudentToGroup();
            } else if (inputData.equals("RSFG")) {
                journal.removeStudentFromGroup();
            } else if (inputData.equals("LG")) {
                journal.outListOfGroups();
            } else if (inputData.equals("LS")) {
                journal.outListOfStudents();
            } else if (inputData.equals("LSB")) {
                journal.outListOfSubjects();
            } else if (inputData.equals("LR")) {
                journal.outListOfRatingsAllStudents();
            } else if (inputData.equals("ARTS")) {
                journal.addRatingToStudent();
            } else if (inputData.equals("RRFS")) {
                journal.removeRatingFromStudent();
            } else if (inputData.equals("ARTGBS")) {
                journal.addRatingsToGroupBySubject();
            } else if (inputData.equals("CJ")) {
                journal = new Journal();
            } else if (inputData.equals("SJ")) {
                ioJournal.journalToFile(journal);
            } else if (inputData.equals("LJ")) {
                journal = ioJournal.journalFromFile();
            } else if (inputData.equals("SXML")) {
                ioJournal.saveToXML(journal);
            } else if (inputData.equals("LXML")) {
                journal = ioJournal.loadFromXML();
            } else if (inputData.equals("H")) {
                System.out.println("AG, RG, AS, RS, ASTG, AOSTG, RSFG, LG, LS, LSB, LR, ARTS, RRFS, ARTGBS, CJ, SJ, LJ, SXML, LXML, E, H");
            }
        }
    }

    private static String inputFromKeyboard() {
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
}
