public class Child {
    //PASTE YOUR WORK FROM LAB05 HERE
    private String name;
    private int age;
    private double bedtime;
    private String sport;
    private String favColor;

    public Child(String name, int age, double bedtime, String sport, String favColor){
        this.name = name;
        this.age = age;
        this.bedtime = bedtime;
        this.sport = sport;
        this.favColor = favColor;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setBedtime(double bedtime){
        this.bedtime = bedtime;
    }
    public double getBedtime() {
        return this.bedtime;
    }
    public void setSport(String sport){
        this.sport = sport;
    }
    public String getSport(){
        return this.sport;
    }
    public void setFavColor(String favColor){
        this.favColor = favColor;
    }
    public String getFavColor(){
        return this.favColor;
    }

    /**
     * For this method, our child will take an instance of a dog to play fetch with.
     * The age of the dog will determine the resulting string as follows:
     * If the dog is younger than 2 or older than 12, return "didn't fetch the ball"
     * If the dog is 2-5 (inclusive), return "got the ball but didn't bring it back"
     * For any other age, return "fetched the ball"
     *
     * @param dog
     * @return string with appropriate phrase
     */
    public String playFetch(Dog dog) {
        if (dog.getAge() < 2 || dog.getAge() > 12) {
            return "didn't fetch the ball";
        } else if (dog.getAge() >= 2 && dog.getAge() <= 5) {
            return "got the ball but didn't bring it back";
        } else {
            return "fetched the ball";
        }
    }

    public static void main(String[] args) {
        Child roman = new Child("Roman", 8, 9.30, "baseball", "yellow");
        Dog buster = new Dog("Buster", 4, "Golden Retriever");
        System.out.println(roman.playFetch(buster)); //should print "got the ball but didn't bring it back"
    }
}
