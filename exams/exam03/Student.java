/** Student Code for Coding Exam 3
 *  Kyle Dickey, I have not given, received, or used any unauthorized assistance.
*/

// define the student class to inherit the person class
public class Student extends Person {
    // define the student class's variables
    public int id;

    // define the student class's constructor
    public Student(String firstName, String lastName, int id) {
        // call the person class's constructor
        super(firstName, lastName);
        // set the student class's id
        this.id = id;
    }
    
    // define the toString method
    public String toString() {
        return "Student: " + firstName + " " + lastName + " " + id;
    }

    // Make sure to add/create a .equals(Object obj) method for Person, and Student. A student ID is unique, so students are equal if the ID is equal, along with their first and last names. For people, they are only unique/equal if both first and last names are equal.
    public boolean equals(Object obj) {
        // check if the object is a student
        if (obj instanceof Student) {
            // cast the object to a student
            Student student = (Student) obj;
            // check if the student's id is equal to this student's id
            if (student.id == this.id) {
                // check if the student's first name is equal to this student's first name
                if (super.equals(student)) {
                    // return true
                    return true;
                }
            }
        }
        // return false
        return false;
    }

    // define the main method for testing
    // public static void main(String[] args) {
    //     // create a student
    //     Student student = new Student("John", "Doe", 123456789);
    //     // print the student
    //     System.out.println(student);
    //     // create a student
    //     Student student2 = new Student("John", "Doe", 123456789);
    //     // print the student
    //     System.out.println(student2);
    //     // check if the students are equal
    //     System.out.println(student.equals(student2));
    // }
}