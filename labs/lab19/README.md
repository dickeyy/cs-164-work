# Lab19PlayingCards
For your final practical project and for many instances in the future, you will need to make a `compareTo()` method to compare the values of objects you make. For 
example, today you will work with a PlayingCard class, which has two variables associated with it: `suit` and `rank`. The compiler has no idea how to sort the 
PlayingCard objects, so you will need to tell it how to compare them. You will write two different `compareTo()` methods that will compare the Cards by `suit` and `rank`.

For ease of access, here is the [javadoc](https://csu-compsci-cs163-4.github.io/Lab19PlayingCards/)

## Step 1: Getting Started
There are three methods you will be working on today: `compareTo`, `compareRank`, and `compareSuit`. `compareTo` will call the other two methods. All of it is completed
except for the `if` statement. The following [website](https://www.baeldung.com/java-compareto) has some good information on the basics of the `compareTo()` method.

## Step 2: Implementation
Go through the javadoc and read the specifications for cards. Cards will be ordered first by suit `CLUBS`, `DIAMONDS`, `HEARTS`, and `SPADES`. They will then be ordered by
rank `1,2,3,4,5,6,7,8,9,10,11,12,13`.  

For `compareRank`, you will just have to find if the number of a card is lower, higher, or the same as the other card.  
For `compareSuit`, you will have to compare the card's suit against the other card's using the order mentioned above.  

`compareTo` will usually be used like: `playingCard1.compareTo(playingCard2)`. In this case, `playingCard1` is the object that calls `compareTo`. That means we can use
words like `this.rank` and `this.suit`. For `playingCard2`, we will have to call getters. In each method, `playingCard2` will be described as `rightSidePlayingCard`.

## Step 3: Finishing up
Once you have tested your code, click through the link on Canvas, upload your files to Zybooks and click submit for grading.
