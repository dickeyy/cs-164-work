public class Wtf {
    public static void main(String[] args) {
        String foco = "Fort Collins;40°35'6.936°\"N;105°5'3.9228\"W";

        System.out.println(foco.substring(foco.indexOf(";"+1, foco.lastIndexOf(";"))));
        System.out.println(foco.substring(0, foco.indexOf(";")));
        System.out.println(foco.substring(foco.lastIndexOf(";"))+1);
    }
}
