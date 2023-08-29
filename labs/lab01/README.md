# Lab01BeginningsAndBugs
Welcome to your first lab!!

The primary focus of this lab is to get you familiar with variables and debugging so that you can recognize common mistakes before you make them. There are 3 methods in the Bugged.java file. Each of these methods has a comment with the number of errors you can find within the code next to it to help guide your searching. 

# Step 1: Debugging
There are a few popular ways you can debug methods. These will be explained below.

## Reading

The first way you can debug is probably the simplest: reading. Try reading through the code line by line and seeing if your eye catches on any of the issues. This method can be a bit time-consuming without using the other methods, but simply reading over your code can be a great way to check for errors on a small scale.

## Running

The next way you can debug is by running your code. When you run your code, your compiler will do its best to read through your code to translate it to computer language. If it catches any issues (or errors), your compiler will stop reading and scream loudly at you to get your attention. The resulting error message should include the general line the compiler thinks the error is as well as what it thinks the error could be. You can use this message as a general guideline for your hunt as you search for the problem. Remember, the compiler is not always completely accurate, so the error could be different than what it is assuming (maybe it's a symptom of a different problem) and it could be on a different line around the line your compiler is complaining about.

## Printing

When you're really stuck in your debbugging, you can use print statements. These print statements can be used to print variable values to check their validity, or even just to print random garbage to prove the computer got that far. Print statements are especially useful for semantical errors, or errors that do not feature poorly written code, just code that does the wrong thing. You can use print statements to check if your computer enters if statements, loops, or even if it just got far enough down to read a line. This way, you can better triangulate where a problem is when the error your compiler throws is unhelpful.

# Step 2: Turn it In!
Once you've successfully debugged the code and can get it to run successfully, turn it in to submit mode on Zybooks to get credit.