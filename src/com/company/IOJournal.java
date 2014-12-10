package com.company;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

/**
 * Created by Reaktor on 09.12.2014.
 */
public class IOJournal {
    public void saveToXML(Journal journal) {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Journal", Journal.class);
        xstream.alias("Group", Group.class);
        xstream.alias("Rating", Rating.class);
        xstream.alias("Student", Student.class);
        xstream.alias("Subject", Subject.class);
        xstream.setMode(XStream.NO_REFERENCES);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("base.xml");
            xstream.toXML(journal, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Journal loadFromXML() {
        Journal journal = new Journal();
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("Journal", Journal.class);
        xstream.alias("Group", Group.class);
        xstream.alias("Rating", Rating.class);
        xstream.alias("Student", Student.class);
        xstream.alias("Subject", Subject.class);
        xstream.setMode(XStream.NO_REFERENCES);
        try {
            FileInputStream fileInputStream = new FileInputStream("base.xml");
            xstream.fromXML(fileInputStream, journal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return journal;
    }

    public void journalToFile(Journal journal) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("base.dat"))) {
            outputStream.writeObject(journal);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Journal journalFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("base.dat"))) {
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
