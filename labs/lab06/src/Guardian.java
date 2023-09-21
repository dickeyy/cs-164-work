public class Guardian {
    //PASTE YOUR WORK FROM LAB05 HERE
    private String name;
    private int age;
    private String parentingStyle;
    private String favColor;

    public Guardian(String name, int age, String parentingStyle, String favColor){
        this.name = name;
        this.age = age;
        this.parentingStyle = parentingStyle;
        this.favColor = favColor;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setParentingStyle(String parentingStyle){
        this.parentingStyle = parentingStyle;
    }

    public String getParentingStyle(){
        return parentingStyle;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
    }

    public String getFavColor() {
        return favColor;
    }

    /**
     * For this method, the guardian will take an instance of the child and determine how to play
     * with them depending on their traits as follows:
     * if the child's favorite color is blue, orange, or black, return "played pretend"
     * if the child's sport includes the word "ball", return "played sports"
     * if the child is older than 12 (not inclusive), return "played video games"
     * if none of the above conditions are met, return "played board games"
     *
     * @param child
     * @return appropriate string for what guardian and child did
     */
    public String play(Child child) {
        if (child.getFavColor().equals("blue") || child.getFavColor().equals("orange") || child.getFavColor().equals("black")) {
            return "played pretend";
        } else if (child.getSport().contains("ball")) {
            return "played sports";
        } else if (child.getAge() > 12) {
            return "played video games";
        } else {
            return "played board games";
        }
    }

    /**
     * Our guardian likes to watch tv. However, they are only able to watch TV if their child is asleep.
     * For this method, compare the current time to the child's bedtime.
     * If it's past the child's bedtime, return true
     * Otherwise, return false
     *
     * @param child
     * @param time
     * @return true/false
     */
    public boolean watchTv(Child child, double time){
        if (time > child.getBedtime()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Guardian Max = new Guardian("Max", 29, "gentle", "green");
        System.out.println(String.format("Meet %s. They are age %d, their favorite color is %s, and they are a %s parent.", Max.getName(), Max.getAge(), Max.getFavColor(), Max.getParentingStyle()));
    }
}
