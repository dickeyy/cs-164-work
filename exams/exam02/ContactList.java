package exams.exam02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/*
 * The purpose of the application you are completing is to read in a comma separated value file (CSV), and load that information into an A*rrayList of Contact objects. Once that is done, it will print out the contacts in a formatted manner.

 * For example if the file contains:

 * Scoobert "Scooby" Doo,scoobysnack@mysteryinc.com,9703221111
 * Norville "Shaggy" Rogers,shaggy@mysteryinc.com,(970) 111-2222
 * Daphne Blake,not_helpless@mysteryinc.com,(970) 222-3333
 * Velma Dinkley,MysteryLover@mysteryinc.com,9701112222
 * Fred Jones,trapman@mysteryinc.com,970.782.2910
 * The output of the program will be:

 * Scoobert "Scooby" Doo (scoobysnack)
 * phone:(970) 322-1111  email:scoobysnack@mysteryinc.com

 * Norville "Shaggy" Rogers (shaggy)
 * phone:(970) 111-2222  email:shaggy@mysteryinc.com

 * Daphne Blake (not_helpless)
 * phone:(970) 222-3333  email:not_helpless@mysteryinc.com

 * Velma Dinkley (mysterylover)
 * phone:(970) 111-2222  email:MysteryLover@mysteryinc.com

 * Fred Jones (trapman)
 * phone:(970) 782-2910  email:trapman@mysteryinc.com
 * Most your work will be in Contact.java with ContactList.java only focusing on reading in the file, and storing the ArrayList.
*/


/**
 * Student Code for Coding Exam 2
 * Put your name here, and the CSU honor code
 * 
 */
public class ContactList {
    private ArrayList<Contact> contacts = new ArrayList<>();


    /**
     * Reads a comma separated value file of the format
     * Name,Email,Phone
     * 
     * And builds a new contact based on that list
     * (1) one contact per line of file
     * (2) stores the contact in ArrayList<Contact> contacts.
     * 
     * You do not have to worry about the line being in the correct format,
     * but you should be careful about empty / blank lines due to
     * some operating systems needing them at the end of files.
     * (hint: !line.isEmpty())
     * 
     * Testing hint: this is the last point of the coding exam. We will
     * test with the provided file, and a few other files to
     * make sure you are not coding specific to that one file.
     * 
     * @param fileName name of file
     */
    public void loadListFromFile(String fileName) {
        try {

            // open file
            File file = new File("./exams/exam02/"+fileName);
            Scanner scanner = new Scanner(file);

            // read in file
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.isEmpty()) {
                    // parse line
                    Contact contact = parseLine(line);
                    // add to list
                    contacts.add(contact);
                }
            }

            // close file
            scanner.close();

        }catch(Exception ex) {
            System.err.println("Error reading file: " + ex.getMessage());
            System.exit(1);
        }

    }

    // this method is untested, and simply here as a hint to help you
    // write the code for loadListFromFile - based on examples
    // from lecture notes
    private Contact parseLine(String line) {
        String[] parts = line.split(",");
        String name = parts[0];
        String email = parts[1];
        String phone = parts[2];

        // create contact
        Contact contact = new Contact(name, email, phone);

        return contact;
    }

    /** provided methods - used for testing  - to not modify*/
    public ArrayList<Contact> getContacts(){
        return contacts;
    }

    public void printList() {
        for(Contact c : contacts) {
            System.out.println(c.getName() + String.format(" (%s)", c.getEName()));
            System.out.printf("   phone:%s  email:%s\n\n", c.getPhone(), c.getEmail());
        }
    }

    // end provided methods

    public static void main(String[] args) {
        ContactList list = new ContactList();
        list.loadListFromFile("contacts.csv");

        list.printList();
    }
}

