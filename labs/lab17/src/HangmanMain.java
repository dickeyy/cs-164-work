public class HangmanMain {
    
    /**
     * Your main method must do the following:
     * * Create a new HangmanGame object
     * * Call the printScreen() method (remember how to call methods on different objects!)
     * * Call initializeWords(), passing in a fileName, which requires the input from the user
     * * Call wordSelect().
     * * Print the initial hangman gallows by calling getZero().
     * * Call printWordProgress()
     * * While the game is not finished, get input from the user on what letter they guess 
     * using getInput("Guess a letter: ") and call guess(), passing in the guess input.
     * @param args
     */
    public static void main(String[] args) {
        
        HangmanGame game = new HangmanGame();
        game.view.printScreen();
        String filename = game.view.getInput("What file do you want to use?");
        game.initializeWords(filename);
        game.wordSelect();
        game.view.getZero();
        game.printWordProgress();

        while(!game.finished) {
            game.guess(game.view.getInput("Guess a letter: "));
        }

    }
}
