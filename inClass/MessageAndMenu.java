import java.util.Scanner;

public class MessageAndMenu {
    private Scanner scn;

    public MessageAndMenu() {
        scn = new Scanner(System.in);
    }

    public void end() {
        System.out.println("Goodbye!");
    }

    public int menu() {
        System.out.println("Choose one of those options:");
        System.out.println("(0) Exit");
        System.out.println("(1) Print the first 100 even numbers");
        System.out.println("(2) Print the first 100 odd numbers");
        System.out.println("(3) Exponent multiplication");
        System.out.println("Select your choice");
        return scn.nextInt();
    }

    public int read () {
        System.out.println("Enter a number");
        return scn.nextInt();
    }

    public String even() {
        return "The first 100 even numbers are: ";
    }
}
