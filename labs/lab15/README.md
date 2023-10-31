# Lab 15 - Recursion
This lab will focus upon implementing some recursive methods. You have previously learned about recursion from past lectures and this lab will help you put some of that knowledge to use!

For ease of access, here is the [javadoc](https://csu-compsci-cs163-4.github.io/Lab15Recursion/package-summary.html).

## Pre-Step: Walkthrough & Compilation
This lab is focused upon your implementation of recursive methods, but it may help you to walkthrough the program, notably the `methodToCall()` method because it contains a `switch` statement that y'all have recently learned about.

Once you feel confident on the workings of this program, hop over to your self-explanations!

## Step 1: Self-Explanation
There are three self-explanations to be completed, one for each of your recursive implementations. You will need to read the javadocs before writing out your ideas.

For these explanations and implementations **do not** use loops, you must use recursive calls to solve these problems.

For these explanations focus upon detailing your base and recursive cases that you will need for recursion in each method.

## Step 2: Implementation
And now for the best part, implementing your methods! Recursion can be a difficult concept, so I would highly recommend, creating a tree or doodle to follow what your recursive methods are doing at each step of their execution. This can be key to understanding recursion.

If you would like to go beyond the testing that can be accomplished with just `RecursionMain`, you can easily create your own `main` method in another class and create corresponding tests!

## Step 3: Turning In
For turning in this lab, make sure to have your TA check off your self-explanation and then turn in `RecursionHelper.java` to zyBooks. Online students will not have the option to submit their self-explanations but it is still highly recommended that it is completed to help better understand the code.

## Additional Information - Recursion
When creating a recursive method you must focus your attention onto the base case and the recursive case.
<ul>
  <li>Base case: This is the case or conditional that stops the recursive calls, commonly use when a number reaches 0, or a String's characters have been exhausted.</li>  
  <li>Recursive case: This the case where you are reducing a problem down into a subproblem, such as removing a character from a String, or subtracting a value from a passed parameter.</li>
</ul>
