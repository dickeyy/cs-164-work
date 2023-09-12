package exams.exam01;
import java.util.Scanner;

/**
 * Kyle Dickey, I have not given, received, or used any unauthorized assistance.
*/

public class Miniprogram {
    private Scanner scanner = new Scanner(System.in); // do not modify, use as is

    public int inputInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }

    public char inputChar(String msg) {
        System.out.print(msg);
        return scanner.next().charAt(0);
    }

    public void run() {

        // on the first round, we don't need to ask if they want to run, we can just skip that part
        int value1 = inputInt("Enter a number: ");
        int value2 = inputInt("Enter another number: ");
        LongDivision div = LongDivision.buildLongDivision(value1, value2);
        System.out.println(div.getFormattedString());

        char answer = inputChar("Do you want to run (yes or no)? ");
        while (answer == 'y') {
            value1 = inputInt("Enter a number: ");
            value2 = inputInt("Enter another number: ");
            div = LongDivision.buildLongDivision(value1, value2);
            System.out.println(div.getFormattedString());
            answer = inputChar("Do you want to run again (yes or no)? ");
        }
    }

    public static void main(String[] args) {
        Miniprogram program = new Miniprogram();
        program.run();
        // we do not test main. Add your own tests in here if you want/should

    }
}

