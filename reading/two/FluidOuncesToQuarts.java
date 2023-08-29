package reading.two;
import java.util.Scanner;

public class FluidOuncesToQuarts {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        /* Modify the following code */
      
        double volumeOunces;
        double volumeQuarts;

        volumeOunces = scnr.nextDouble(); 
        volumeQuarts = volumeOunces / 32;

        System.out.printf("%.3f quarts\n", volumeQuarts);
    }
}