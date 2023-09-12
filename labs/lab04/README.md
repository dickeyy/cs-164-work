# Lab04Choices
Data Type/Control Flow Application Lab

Today we will be practicing if statements, switch statements, and practicing our getters/setters in Java by designing an automated coffee shop order system.

# Step 1: Setting the coffee information - the coffee constructor Coffee(char size, int type, String\[] syrups)
The first thing we need to make for our Coffee class is the Coffee constructor. To make the constructor, find `Coffee(char size, int type, String[] syrups)`. Set the class variables size, type, and syrups to the appropriate information. To do this, use if statements to set the variables size and typeVal.
 
Size will either be: 
 ```
's', which should set the class variable size to "small"
'm', which should set the class variable size to "medium"
'l', which should set the class variable size to "large"
Your default size should be "medium"
 ``` 
Type will either be:
 ```
 1, which should set the class variable typeVal to "iced"
 2, which should set the class variable typeVal to "blended"
 3, which should set the class variable typeVal to "hot"
 Your default type should be "hot"
  ```

Syrups will be written for you, as it uses Arrays, which must be initialized in a special way. Read over the code to make sure you understand it for future labs.

   Ex: 
   ```java
   String[] tem = {"caramel", "chocolate"};
   Coffee myOrder = new Coffee('s', 1, tem);
   System.out.println("TESTING CONSTRUCTOR SIZE: " + myOrder.size); // should return "small" 
```
# Step 2: Getters and Setters -- getSize(), getType(), getSyrups(), setSize(String siz), setType(String typ), setSyrups(String\[] syrup)
Another basic part of most Java classes are getters and setters. getters get the values of variables and setters set the values of variables. In Coffee, we have three class variables: size, type, syrups. Keep in mind that private variables can ONLY be accessed outside of the class by getters and setters. 

For these functions:
```
1. Make getSize() return the size of the drink
2. Make getType() return the type of drink
3. Make getSyrups() return the list of syrups
4. Make setSize(String siz) set the class variable size to siz (this will not return anything)
5. Make setType(String typ) set the class variable type to typ (this will not return anything)
6. setSyrups(String[] syrup) will be written for you, as Arrays have special behavior.
```

  Ex: 
  ```java
  String[] temp = {"caramel", "chocolate"};
  Coffee myOrder = new Coffee('s', 1, temp);
   System.out.println("TESTING CONSTRUCTOR SIZE: " + myOrder.getSize()); // should return "small" 
   myOrder.setSize("medium");
   System.out.println("TESTING GET SIZE: " + myOrder.getSize()); // should return "medium"
```
# Step 3: Calculating the Order Price -- calculatePrice()
Things like size, type of drink, and syrups can have an effect on the total price of a coffee order. For the   `calculatePrice() ` method, use either switch or if statements to make the following checks:

 ```
 1. If the size is small, the base price is 3.0. 
 2. If the size is medium, the base price is 4.0. 
 3. If the size is large, the base price is 5.0.
 4. If the order is blended, add an extra .5 to the price.
 5. Find the for-loop for flavors. if the flavor is "chocolate", "vanilla", or "caramel", it is free. For any other flavor, add .5.
 ```

  Ex: 
  ```java
  String[] temp1 = {"caramel", "chocolate"};
  String[] temp2 = {"chocolate", "mint", "lavender"};
  Coffee order1 = new Coffee('s', 1, temp1);
  Coffee order2 = new Coffee('m', 2, temp2);
  System.out.println("TESTING PRICE: " + order1.calculatePrice()); // This should return 3.0
  System.out.println("TESTING PRICE: " + order2.calculatePrice()); // This should return 5.5
```


# Step 4: Turn It In!
  Turn it in to submit mode on Zybooks

#Reminder: Switch Cases
There are some times when the only thing your if statement is checking is the value of a single variable. In these cases, it is easier to use a *switch statement*. All cases in a switch statement should be terminated by a break, or they will walk through into the next case without checking for correctness until they reach a break statement.

Example:
```
switch(i) {
            case(0):
                System.out.println("Zero");
                break;
            case(1):
                System.out.println("One");
            case(2):
                System.out.println("Two");
                break;
            default:
                System.out.println("Number");
            
        }
  ```
  For i = 1, the print would be:
  ```
  One
  Two
  ```
  While i = 0 would print:
  ```
  Zero
  ```
  i = 17 would print:
  ```
  Number
  ```
  because there is no case for 17, so it goes to the default.