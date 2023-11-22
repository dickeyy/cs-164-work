## Lab 17 - Hangman
 
For the most part this semester, we have provided the `main()` method to control your program and you implemented specific methods. This time, we've provided you all the methods needed to make a [hangman](https://en.wikipedia.org/wiki/Hangman_(game)) game, and you need to write the `main()` method. The [javadoc](https://csu-compsci-cs163-4.github.io/Lab17Hangman/package-summary.html) has what methods were already written for you and their basic functionality. This will be very helpful for `controller` method in the Practical! 

## Step 1: Getting Started
Take a look at the [javadoc](https://csu-compsci-cs163-4.github.io/Lab17Hangman/package-summary.html) and the code provided to you. Refresh/familiarize yourself with the rules of [hangman](https://en.wikipedia.org/wiki/Hangman_(game)).

## Step 2: Implementation
Create a file called `HangmanMain`. Make a new `main()` method. This is where you will write all your code.

For this method, you will need to:
1. Create a new `HangmanGame` object
2. Call the `printScreen()` method (remember how to call methods on different objects!)
3. Use `getInput("Would you like easy or hard words? ")` to get user input on what difficulty they would like
4. Call `initializeWords()`, passing in `selectDifficulty()`, which requires the input from the user you just got.
5. Call `wordSelect()`.
6. Print the initial hangman gallows by calling `getZero()`.
7. Call `printWordProgress()`
8. While the game is not finished, get input from the user on what letter they guess using `getInput("Guess a letter: ")` and call `guess()`, passing in the guess input.

Take a moment to run the game and make sure it works properly.

## Step 3: Finishing up
To turn in your assignment, click through the link on Canvas, upload your files to Zybooks and click submit for grading. Note you can do this more than once.

Note:

`HardHangmanWords.txt` was modified slightly from https://www.hangmanwords.com/words. 
