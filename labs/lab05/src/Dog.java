/*
 * Self Explanation:
 * 
 * 1. What is a setter?
 *  a. A setter is a method that sets the value of a field.
 * 
 * 2. What is a getter?
 *  a. A getter is a method that gets the value of a field.
 * 
 * 3. Why do you think we have/use constructors?
 *  a. We use constructors to initialize the object's state.
 * 
 * 4. What do we call the object variables Household has of type Child, Guardian, and Dog?
 *  a. They are called instance variables
*/

public class Dog {
    private String name;
    private int age;
    private String breed;

    public Dog(String name, int age, String breed){
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setBreed(String breed){
       this.breed = breed;
    }
    public String getBreed(){
        return this.breed;
    }
    public static void main(String[] args) {
        Dog Buster = new Dog("Buster", 4, "Golden Retriever");
        System.out.println(String.format("Name: %s\nAge: %d\nBreed: %s", Buster.getName(), Buster.getAge(), Buster.getBreed()));
    }
}
