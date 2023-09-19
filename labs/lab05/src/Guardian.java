public class Guardian {
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

    public static void main(String[] args) {
        Guardian Max = new Guardian("Max", 29, "gentle", "green");
        System.out.println(String.format("Meet %s. They are age %d, their favorite color is %s, and they are a %s parent.", Max.getName(), Max.getAge(), Max.getFavColor(), Max.getParentingStyle()));
    }
}
