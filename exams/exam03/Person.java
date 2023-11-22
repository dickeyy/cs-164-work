/** Student Code for Coding Exam 3
 *  Kyle Dickey, I have not given, received, or used any unauthorized assistance.
*/

public class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return "Person: " + firstName + " " + lastName;
    }
   
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (person.firstName.equals(this.firstName)) {
                if (person.lastName.equals(this.lastName)) {
                    return true;
                }
            }
        }
        return false;
    }
   
}