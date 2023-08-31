/*
 * Step directions are copy pasted from
 * https://github.com/CSU-CompSci-CS163-4/Lab02OpenPizzaOrderingApplication/blob/main/README.md
*/ 

package labs.lab02;

public class Pizza {

    // Step 1: declare variables
    public int pizzaSize;
    public int numToppings;
    public double pizzaPrice;

    // Step1.1: set the size of the pizza
    public void setSize(int size) {
        pizzaSize = size;
    }

    // Step 1.2: set the number of toppings
    public void setToppings(int toppings) {
        numToppings = toppings;
    }

    /*
        Step 2: calculateBasePizzaPrice()
        To begin with this method, the variables pizzaSize & numToppings must be set within the Pizza object, this is already done within the application and tester files.

        Using the pizzaSize & numToppings, it sets the correct pizza price. The pizza price ranges from 1-3, whichever size is chosen is multiplied by a factor of 6.5 and added to the pizzaPrice variable that also present within the Pizza object. The same applies to numToppings, 0-10, which is multiplied by a factor of .65.

        Example: Given a size 2 pizza & 0 toppings the pizza's base price would be $13.00. Given a size 3 pizza with 4 toppings the pizza's base price would be $22.10.
    */

    public void calculateBasePizzaPrice() {
        pizzaPrice = (pizzaSize * 6.5) + (numToppings * .65);
    }

    /*
        Step 3: addDeliveryFee(int delivery)
        This method takes a singular parameter, delivery, which will be a 1 or 0 depending if the application user requested delivery. When the delivery is 1, 5 will be added to the running pizzaPrice variable. When the delivery is 0, no fee needs to be added.

        A simple multiplication statement is the best solution to this method.
    */

    public void addDeliveryFee(int delivery) {
        if (delivery == 1) {
            pizzaPrice += 5;
        }
    }

    /*
        Step 4: addPizzaTax(int taxRate)
        This methods single parameter is a whole number, the taxRate variable. Using this taxRate, you will calculate the tax that would be applied to this pizza using the base price and added delivery fee.

        The taxRate parameter will be provided as a whole number, so it should be converted to a decimal to make the tax calculation more simple.
    */

    public void addPizzaTax(int taxRate) {
        double tax = (taxRate / 100.0) * pizzaPrice;
        pizzaPrice += tax;
    }

    /*
        Step 5: getPrepTime()
        getPrepTime follows the same logic as the calculateBasePrice() method, but instead of a price, this method will calculate the time it takes to prep this pizza and then return that value. The pizzaSize is now multiplied by a factor of 8 and then added to a variable. The numToppings is then multiplied by a factor of 1.5 and added to you previously declared variable.

        After you add both products to your variable, you then return it. 
    */

    public int getPrepTime() {
        int prepTime = (pizzaSize * 8) + (int) (numToppings * 1.5);
        return prepTime;
    }

    /*
        Step 6: getPizzaPrice()
        This method is very simple, it just returns the pizzaPrice variable.
    */

    public double getPizzaPrice() {
        return pizzaPrice;
    }

}