import java.util.Scanner;

public class MoreRecursionMain {
    
    public static void methodToCall(int choice, Scanner scnr) {
        MoreRecursionHelper rHelp = new MoreRecursionHelper();
        while(true) {
            switch (choice) {
                case 0: System.out.println("Now exiting.");
                        scnr.close();
                        System.exit(1);
                case 1: System.out.print("Enter the number you would like to convert to binary: ");
                        int binaryRepresentation = rHelp.toBinary(scnr.nextInt());
                        System.out.println("Your converted number: " + binaryRepresentation + "\n");
                        break;
                case 2: System.out.print("Enter the number of rows you would like your pyramid to have: ");
                        int total = rHelp.pyramidTotal(scnr.nextInt());
                        System.out.println("Your pyramid has a total of " + total + " blocks!\n");
                        break;
                case 3: System.out.print("Enter a word to generate all combinations of: ");
                        String input = scnr.next();
                        System.out.println("Generated combinations: ");
                        rHelp.combinations(input, -1, "");
                        System.out.println();
                        break;
                default:System.out.println("Input not recognized.");
            }
            printChoices();
            choice = scnr.nextInt();
        }
    }
    
    public static void printChoices() {
        System.out.println("What method would you like to call?");
        System.out.println("1. toBinary()");
        System.out.println("2. pyramidTotal()");
        System.out.println("3. combinations()");
        System.out.println("Please type 1, 2, or 3.");
        System.out.println("Or type 0 to exit.");
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Welcome to your new and improved recursion program!");
        printChoices();

        methodToCall(scnr.nextInt(), scnr);
    }
}
