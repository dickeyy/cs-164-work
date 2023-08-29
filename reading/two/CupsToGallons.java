package reading.two;
import java.util.Scanner;


public class CupsToGallons {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        double volumeCups;
        double volumeGallons;

        volumeCups = scnr.nextDouble();

        volumeGallons = volumeCups / 16.0;

        /* Your code goes here */
        
        System.out.println("1 gallon = 16 cups");
        System.out.printf("%.1f cups = %.3f gallons\n", volumeCups, volumeGallons);

    }
}
