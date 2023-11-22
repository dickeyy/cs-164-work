import java.util.Scanner;

public class HangmanView {
    Scanner scanner = new Scanner(System.in);
    /**
     * Prints an ASCII art String to represent the hangman with no parts on the board.
     * Displayed when no incorrect guesses were made.
     */
    public void getZero(){
        System.out.println(
                        "   +----+\n" +
                        "   |    |\n" +
                        "        |\n" +
                        "        |\n" +
                        "        |\n" +
                        "       ---\n");
    }
    /**
     * Prints an ASCII art String to represent the hangman with one part on the board -
     * the head. Displayed when one incorrect guess was made.
     */
    public void getOne(){
        System.out.println(
                        "   +----+\n" +
                        "   |    |\n" +
                        "   O    |\n" +
                        "        |\n" +
                        "        |\n" +
                        "       ---\n");
    }
    /**
     * Prints an ASCII art String to represent the hangman with two parts on the board -
     * the head and body. Displayed when two incorrect guesses were made.
     */
    public void getTwo(){
        System.out.println(
                        "   +----+\n" +
                        "   |    |\n" +
                        "   O    |\n" +
                        "   |    |\n" +
                        "        |\n" +
                        "       ---\n");
    }
    /**
     * Prints an ASCII art String to represent the hangman with three parts on the board -
     * the head, body, and right arm. Displayed when three incorrect guesses were made.
     */
    public void getThree(){
        System.out.println(
                        "   +----+\n" +
                        "   |    |\n" +
                        "   O /  |\n" +
                        "   |    |\n" +
                        "        |\n" +
                        "       ---\n");
    }
    /**
     * Prints an ASCII art String to represent the hangman with four parts on the board -
     * the head, body, right arm, and left arm. Displayed when four incorrect guesses were made.
     */
    public void getFour(){
        System.out.println(
                "   +----+\n" +
                        "   |    |\n" +
                        " \\ O /  |\n" +
                        "   |    |\n" +
                        "        |\n" +
                        "       ---\n");
    }
    /**
     * Prints an ASCII art String to represent the hangman with five parts on the board -
     * the head, body, right arm, left arm, and right leg. Displayed when five incorrect guesses were made.
     */
    public void getFive(){
        System.out.println(
                "   +----+\n" +
                        "   |    |\n" +
                        " \\ O /  |\n" +
                        "   |    |\n" +
                        "    \\   |\n" +
                        "       ---\n");
    }
    /**
     * Prints an ASCII art String to represent the hangman with six parts on the board -
     * the head, body, right arm, left arm, right leg, and left leg. Displayed when six incorrect guesses were made.
     */
    public void getSix(){
        System.out.println(
                "   +----+\n" +
                        "   |    |\n" +
                        " \\ O /  |\n" +
                        "   |    |\n" +
                        "  / \\   |\n" +
                        "       ---\n");
    }

    /**
     * Displays text to console and then grabs user response.
     * @param displayText Text to display to console.
     * @return String input from user
     */
    public String getInput(String displayText){
        System.out.println(displayText);
        return scanner.nextLine();
    }

    /**
     * Prints a welcome screen for the Hangman game.
     */
    public void printScreen(){
        System.out.println("WELCOME TO HANGMAN!");
    }

    public static void main(String[] args) {
        HangmanView h = new HangmanView();
        h.getZero();
        h.getOne();
        h.getTwo();
        h.getThree();
        h.getFour();
        h.getFive();
        h.getSix();
    }
}
