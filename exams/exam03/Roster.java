/** Student Code for Coding Exam 3
 *  Kyle Dickey, I have not given, received, or used any unauthorized assistance.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Roster {

    List<Person> people;

    public Roster(String filename) {
        people = new ArrayList<Person>();
        initializeListFromFile(filename);
    }

    public void initializeListFromFile(String filename) {
        try {

            // create a scanner to read the file
            Scanner scanner = new Scanner(new File(filename));
            // loop through the file
            while (scanner.hasNextLine()) {
                // get the next line
                String line = scanner.nextLine();
                // split the line by spaces
                String[] parts = line.split(" ");
                // check if the line is a student
                if (parts.length == 3) {
                    // create a student
                    Student student = new Student(parts[0], parts[1], Integer.parseInt(parts[2]));
                    // add the student to the list
                    people.add(student);
                } else {
                    // create a person
                    Person person = new Person(parts[0], parts[1]);
                    // add the person to the list
                    people.add(person);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
       // example main - you should change this to match whatever file you create to test everything
        Roster r = new Roster("test");
        System.out.println(r.people);
    }

}