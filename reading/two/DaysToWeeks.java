package reading.two;
import java.util.Scanner;

public class DaysToWeeks {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        /* Your code goes here */
        double lengthDays;
        double lengthWeeks;

        lengthDays = scnr.nextDouble(); 
        lengthWeeks = lengthDays / 7;

        System.out.printf("%.3f\n", lengthWeeks);
    }
}