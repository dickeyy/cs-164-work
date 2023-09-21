public class Dog {
    //PASTE YOUR WORK FROM LAB05 HERE
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
