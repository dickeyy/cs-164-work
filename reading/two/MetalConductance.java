package reading.two;
import java.util.Scanner;

public class MetalConductance {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        /* Your code goes here */
        double electricCurrent;
        double electricVoltage;

        electricCurrent = scnr.nextDouble();
        electricVoltage = scnr.nextDouble();

        System.out.printf("Metal conductance is %.5f\n", electricCurrent / electricVoltage);
    }
}
