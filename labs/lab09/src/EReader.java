import java.io.File;
import java.io.FileNotFoundException;
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

    /**
     * This method's job is simply to set the class's fileReader variable to a scanner
     * made from a file using the inputted book string.
     *
     * Make sure to write your code in the try-catch loop. Since we're working with file's, we need to catch files that cannot be found.
     *
     * @param book
     */
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

    public void go(){
        options();
        String input = userInput.nextLine();

        while(!input.equalsIgnoreCase("x")){

            String bookName = books.get(Integer.parseInt(input) - 1);

            System.out.println("Now opening: " + bookName);
            System.out.println();

            loadBook(bookName);

            System.out.println("Press Enter to go to next line, or enter X to close the book.");
            openBook();

            System.out.println("Closing book...");
            options();

            input = userInput.nextLine();
        }

    }

    public static void main(String[] args){
        ArrayList<String> myBooks = new ArrayList<>();

        myBooks.add("Great_Gatsby.txt");
        myBooks.add("Alice_In_Wonderland.txt");
        myBooks.add("US_Constitution.txt");

        EReader myBrokenEreader = new EReader(myBooks);

        myBrokenEreader.go();
    }
}
