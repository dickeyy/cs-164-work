import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EReader {
    Scanner fileReader;
    Scanner userInput = new Scanner(System.in);
    ArrayList<String> books;

    public EReader(ArrayList<String> books){
        this.books = books;
    }

    public void listBooks(){
        System.out.println("Choose from the following list of books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ": " + books.get(i));
        }
        System.out.println();
        System.out.println("Enter the number for the entry you would like to read or X to exit.");
    }

    public void options(){
        System.out.println("Enter X to turn off ereader at any time.");
        listBooks();
    }

    public void loadBook(String book){
        try {
            
            this.fileReader = new Scanner(new File(book));

        }
        catch (FileNotFoundException e){
            System.out.println("Uh oh! I couldn't find that file!");
        }
    }

    /**
     * This method's job is to return the next line in the fileReader
     */
    public String displayLine(){

        if (fileReader.hasNextLine()) {
            return fileReader.nextLine();
        }
        else {
            return "End of book!";
        }

    }

    /**
     * Our ereader has been dropped on the ground so many times that the display has been broken.
     * Now, every part of the display is black except for the top most line. Because of this, when we want
     * to read a book, we can only display one line of it at a time.
     *
     * This method's job is to call and print displayLine() every time the user enters anything other than "x".
     * You will want to use a while loop and call the userInput scanner to retrieve user data.
     * If the user enters "x", exit the loop.
     */
    public void openBook(){
        
        // the user has to press enter when they want to go to the next line
        // however, the user also presses enter after clicking x to exit the book
        // so we need to check if the user has clicked x before we go to the next line
        String input = userInput.nextLine();
        while(!input.equalsIgnoreCase("x")){
            System.out.println(displayLine());
            input = userInput.nextLine();
        }

    }

    /**
     * You modded your broken e-reader to do your math homework for you.
     *
     * To do this, mathReader needs to take the name of the output file to write the results to.
     * You are in third grade, so all of your math homework is in the form "int operator int".
     * Read each line at a time, do the math using mathHelper, then write the solution to the solution file.
     *
     * There is provided pseudocode to help you write the method.
     *
     * @param outputFile
     */

    public void mathReader(String outputFile){
        try {
            PrintWriter output = new PrintWriter(outputFile);
            
            // read in file
            while(fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                // parse line
                int solution = mathHelper(line);
                // write solution to file
                output.println(solution);
            }

            output.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Uh oh! I couldn't find that file!");
        }
    }

    /**
     * mathHelper's job is to take in a string equation, read each part of the equation, and then solve the problem.
     *
     * Some pseudocode has been provided to help you write your code.
     *
     * @param equation
     * @return result of the equation
     */
    public int mathHelper(String equation){
        // split the equation into parts
        String[] parts = equation.split(" ");
        // parse the left and right side of the equation into ints
        int left = Integer.parseInt(parts[0]);
        int right = Integer.parseInt(parts[2]);
        // get the operator
        String operator = parts[1];
        // use a switch statement to determine which operator to use
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            case "%":
                return left % right;
            default:
                return 0;
        }

    }




    public void go(){
        options();
        String input = userInput.nextLine();
        while(!input.equalsIgnoreCase("x")){
            String bookName = books.get(Integer.parseInt(input) - 1);
            System.out.println("Now opening: " + bookName);
            loadBook(bookName);
            System.out.println("Would you like to read this book or solve the problems? Enter R to read or M for math.");
            input = userInput.nextLine();
            System.out.println();
            if (input.equalsIgnoreCase("r")) {
                System.out.println("Press Enter to go to next line, or enter X to close the book.");
                openBook();
            }
            else if (input.equalsIgnoreCase("m")){
                System.out.println("Please provide an output filename for solutions: ");
                input = userInput.nextLine();
                mathReader(input);
            }
            System.out.println("Closing book...");
            options();
            input = userInput.nextLine();
        }
    }

    public static void main(String[] args){
        ArrayList<String> myBooks = new ArrayList<>();
        String path = "";
        myBooks.add(path + "Great_Gatsby.txt");
        myBooks.add(path + "Alice_In_Wonderland.txt");
        myBooks.add(path + "US_Constitution.txt");
        myBooks.add(path + "equations.txt");
        EReader myBrokenEreader = new EReader(myBooks);
        myBrokenEreader.go();
    }
}
