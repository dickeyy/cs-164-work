# Lab18CraftingTable

This lab will focus on 2D Arrays, which is just arrays contained within arrays. These arrays become significantly more complex as we continue to nest them, which we can do, such as making an array that contains arrays which contain arays and so on. In order to get a bit of practice working with these kinds of nested arrays, you will be completing a crafting table simulator.

For ease of access, here is the [javadoc](https://csu-compsci-cs163-4.github.io/Lab18CraftingTable/).

## Pre-Step:
To start this lab, we recommend you compile and run the program to get a feel for how it works for when you have to test. This text-based simulator is meant to simulate a crafting table similar to the one in Minecraft, where users must place specific ingredients onto specific squares in order to craft a recipe.

If you are unfamiliar with the style of crafting we are using, you can check out the [Wikipedia](https://minecraft.fandom.com/wiki/Crafting) to learn more.

Below is an example of what the table should physically look like using the bucket recipe:

| X | X | X |
| --- | --- | --- |
| iron | X | iron |
| X | iron | X |

In Java, it looks more like this:
[["X", "X", "X"], ["iron", "X", "iron"], ["X", "iron", "X"]]

If we stack these rows vertically, we get something like this:

[

["X",    "X",    "X"],

["iron", "X", "iron"],

["X",  "iron",   "X"]

]

Starting to look more like our crafting table, right? 

Remember that when you are accessing items in a 2D array, you must first index into the row, then into the column in that row. 
Ex: table[1][2] would give us row 1, column 2, with item "iron".


## Step 1: Self-Explanation
There are only two self-explanations that must be completed for this lab, one for addItem and one for removeItem. I would recommend illstrating your table and mapping out how you may access the information you need a piece of paper to help with your understanding. 

2D Arrays can be difficult to visualize so that is why it is being urged to draw them!

## Step 2: Implementation
After you finish with your self-explanations you are free to move onto implementing them within your own code, after implemented it may be helpful to draw-along with its execution to help solidify your understanding.

## Step 3: Testing
After finishing you implementation it will help to run through the game and try to create a victory case and see if it functions correctly. Optionally, you can also create more test to test all cases possible for victory conditions.

## Step 4: Turning In
Once finished, be sure to submit your `CraftingTable.java` and make sure to get your self-explanation checked.

# Additional Information
## 2D Arrays
2D Arrays are almost exactly like arrays except that each index in the initial array contains another array which can also be indexed.
``` java
//This 2D Array is empty, but we can still index values within it.
int[][] twoByTwo = new int[2][2];
int[] firstRow = int[0];
int[] secondRow = int[1];
```
 
We can illustrate 2D Arrays by viewing each nested array as a row. \
Using an int[4][4] 2D Array name nums: \
[[0, 1, 2, 3],\
[4, 5, 6, 7],\
[8, 9, 10, 11],\
[12, 13, 14, 15]] \
If an array was initialized as such we would say nums[0][3] to retrieve the value 3.

If we wanted to print the entirety of this 2D Array, we could use two for-loops:
``` java
for(int i = 0; i < nums.length; i++) {
    for(int j = 0; j < nums[i].length; j++) {
        System.out.println(nums[i][j]);
    }
}
```

If you are still running into troubles there is an entire section within the zyBooks going over 2D Arrays, which may help you.
