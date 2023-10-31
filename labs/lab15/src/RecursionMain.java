import java.util.Scanner;

public class RecursionMain {
    
    public static void methodToCall(int choice, Scanner scnr) {
        RecursionHelper rHelp = new RecursionHelper();
        while(true) {
            switch (choice) {
                case 0: System.out.println("Now exiting.");
                        scnr.close();
                        System.exit(1);
                case 1: System.out.println("Enter the String you would like to reverse:");
                        String toReverse = scnr.next();
                        String reversed = rHelp.reverseString(toReverse);
                        System.out.println("Your reversed String: \n" + reversed);
                        break;
                case 2: System.out.println("Enter the number you would like check:");
                        int input = scnr.nextInt();
                        int output = rHelp.armstrongNumber(input, 0);
                        if(input == output) System.out.println(input + " is an Armstrong number.");
                        else System.out.println(input + " is not an Armstrong number.");
                        break;
                case 3: System.out.println("Enter word to check for palindromes: ");
                        String toCheck = scnr.next();
                        boolean palindrome = rHelp.palindromeChecker(toCheck);
                        if(palindrome) System.out.println("Palindrome found!");
                        else System.out.println("No palindrome found.");
                        break;
                default:System.out.println("Input not recognized.");
            }
            printChoices();
            choice = scnr.nextInt();
        }
    }
    
    public static void printChoices() {
        System.out.println("What method would you like to call?");
        System.out.println("1. reverseString()");
        System.out.println("2. armstrongNumber()");
        System.out.println("3. palindromeChecker()");
        System.out.println("Please type 1, 2, or 3.");
        System.out.println("Or type 0 to exit.");
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Welcome to your recursion program!");
        printChoices();

        methodToCall(scnr.nextInt(), scnr);
    }
}
