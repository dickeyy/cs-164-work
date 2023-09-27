# Lab07AirlinePassengers
This lab will focus working with [ArrayLists](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) and the
[For-Each Loop](https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html). There will be some additional information near the bottom of this 
document if you need to gain a better understanding of today's topics.

For ease of access, here is the [javadoc](https://csu-compsci-cs163-4.github.io/Lab07AirlinePassengers/)

## Pre-Step: Testing
Whenever you implement one of these methods, you can test it out in `AirlineMain.java`. Some tests are included here, read through them and figure out what they should print when you run them.

## Step 1: Compilation
At the moment you should be able to compile and run the program that begins in `AirlineMain.java`. If you have any troubles with this you may want to redownload the files or ask a TA.

## Step 2: Self-Explanation
Within the `PassengerList` class you will find the `removePassenger()` method. Given the current code within the `removePassenger()` method you can get some indication as to what it needs,
but the javadoc may also come in handy for this step and the next. The For-Each loop is functional, but 
you will have to fill in the contents of the conditional statement, which is currently *false*.

For this step, write down your self-explanation in the multi-line comment as to what the method is currently doing, and what is needed to make it fully functional. Once you have completed 
this self-explanation, right or wrong, try to apply your proposed change and use the `AirlineMain` `main` method to see if the output is correct.

## Step 3: Implementing
The next methods you will have to implement include: `toString`, `countPassengers`,  and `swapSeats`.  
* `toString` will use the `toString` method found in `Passenger` and place each of these strings on a new line.  
* `countPassengers` will count the number of passengers on a given flight.  
* `swapSeats` will switch the seats between two passengers.
The javadoc will have more detailed explanations.

## Step 4: Testing
Once you have implemented all of the methods, be sure to test them out in your `main`. Here you can print to make sure everything is working correctly. You will have to add your own lines
of code to fully test the program. For example, the tests for `removePassenger` are not included. To test that it works, test it out yourself.

## Step 5: Finishing up
After you have tested out the code and feel confident, turn in your program files to zyBooks.
After turning in your files, show your self-explanation and pseudocode to your TA.
Online students do not have the option to submit their self-explanations but the completion of them are still highly recommended to help better understand the code. 

# Additional Information
## ArrayLists
`ArrayLists` are an incredibly useful data container, meaning you can hold multiple objects of the same type within one! Lets say we wanted to create an `ArrayList` that held the type `String`. We would declare our `ArrayList` like so:
```java
ArrayList<String> strArrList = new ArrayList<String>();
```
Now we have this container, how do we actually add Strings to it to hold? We can use a method that is associated with the `ArrayList` class (somewhat similar to whenever we use `equals()` for a String), this method is the `add()` method:
```java
String toAdd = "Add this to the ArrayList";
strArrList.add(toAdd);
```
It's as simple as that, but now if we wanted to look at what is in our ArrayList we must the `get()` method:
```java
String hasBeenAdded = strArrList.get(0);
```
Now the value of hasBeenAdded is "Add this to the ArrayList". The **0** being used in that previous snippet is used to "get" whatever index is provided, so "getting" 0 gets the 0th index of the ArrayList.

There are many helpful methods associated with the ArrayList data contained which can be checked out [here](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). Focusing on the For-Each loop will be very helpful.

## For-Each Loop
The For-Each loop is a slightly different version of the typical *while* and *for* loop we are so used to using. It begins like a for loop, but there are two portions in the parentheses you must customize. The first portion being the Element that will be looped or iterated through. The second is the container that will be iterated through.
If we were to iterate through our previously created ArrayList it would look like this:
```java
for(String str: strArrList) {
    System.out.println(str);
}
```
So for each time one loop is completed, the `str` variable changes to the next data that is contained within the loop. If we had two Strings in the strArrList, "One" & "Two". On the first iteration, `str` would be equal to "One" and be printed, then on the second iteration it would be equal to "Two" and subsequently printed.

The For-Each loop then realizes there are no more Strings in our container and the loop is exited.
