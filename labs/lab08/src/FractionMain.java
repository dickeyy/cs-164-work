import java.util.Scanner;

public class FractionMain{

    public static void printMenu(){
        System.out.println("Welcome to Fractions!");
        System.out.println("To quit, type 'X'");
        System.out.println("*An improper fraction looks like: 11/22");
        System.out.println("*A proper fraction looks like: 11 11/22");
    }

    public static void go(Scanner scanner){
        printMenu();
        while(true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("X")){
                break;
            }
            else if(input.contains(" ") && input.contains("/")){
                ProperFraction proper = new ProperFraction(input);
                ImproperFraction improper = proper.makeImproper();
                System.out.println("  Proper Fraction: " + proper);
                System.out.println("Improper Fraction: " + improper);
                proper.simplify();
                System.out.println("       Simplified: " + proper);
            }
            else if(input.contains("/")){
                ImproperFraction improper = new ImproperFraction(input);
                ProperFraction proper = improper.makeProper();
                System.out.println("  Proper Fraction: " + proper);
                System.out.println("Improper Fraction: " + improper);
                improper.simplify();
                System.out.println("       Simplified: " + improper);
            }
            else{
                System.out.println("Unrecognized fraction, please try again.");
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        go(scanner);
        scanner.close();
    }
}
