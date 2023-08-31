/*
 * This is a tester file, it is copy pasted from
 * https://github.com/CSU-CompSci-CS163-4/Lab02OpenPizzaOrderingApplication/blob/main/src/PizzaTester.java
*/

package labs.lab02;

public class PizzaTester {
    public void testCalculateBasePizzaPrice() {
        Pizza testPizza1 = new Pizza();
        testPizza1.setSize(2);
        testPizza1.setToppings(4);

        testPizza1.calculateBasePizzaPrice();

        System.out.println("calculateBasePizzaPrice() with size = 2 and toppings = 4:");
        System.out.println("Expected result: 15.6");
        System.out.println("Actual result: " + testPizza1.getPizzaPrice());

        Pizza testPizza2 = new Pizza();
        testPizza2.setSize(3);
        testPizza2.setToppings(10);

        testPizza2.calculateBasePizzaPrice();

        System.out.println("calculateBasePizzaPrice() with size = 3 and toppings = 10:");
        System.out.println("Expected result: 26.0");
        System.out.println("Actual result: " + testPizza2.getPizzaPrice());
        System.out.println();
    }

    public void testAddDeliveryFee() {
        Pizza testPizza1 = new Pizza();

        testPizza1.addDeliveryFee(0);

        System.out.println("addDeliveryFee() with no delivery fee, 0:");
        System.out.println("Expected result: 0.0");
        System.out.println("Actual result: " + testPizza1.getPizzaPrice());

        Pizza testPizza2 = new Pizza();

        testPizza2.addDeliveryFee(1);

        System.out.println("addDeliveryFee() with a delivery fee, 1:");
        System.out.println("Expected result: 5.0");
        System.out.println("Actual result: " + testPizza2.getPizzaPrice());
        System.out.println();
    }

    public void testAddPizzaTax() {
        Pizza testPizza1 = new Pizza();
        testPizza1.setSize(2);
        testPizza1.setToppings(4);

        testPizza1.calculateBasePizzaPrice();
        testPizza1.addPizzaTax(6);

        System.out.println("addPizzaTax() with size = 2, toppings = 4, and taxRate 6:");
        System.out.println("Expected result: 16.536");
        System.out.println("Actual result: " + testPizza1.getPizzaPrice());

        Pizza testPizza2 = new Pizza();
        testPizza2.setSize(3);
        testPizza2.setToppings(10);

        testPizza2.calculateBasePizzaPrice();
        testPizza2.addPizzaTax(10);

        System.out.println("addPizzaTax() with size = 3, toppings = 10, and taxRate 10:");
        System.out.println("Expected result: 28.6");
        System.out.println("Actual result: " + testPizza2.getPizzaPrice());
        System.out.println();
    }

    public void testGetPrepTime() {
        Pizza testPizza1 = new Pizza();
        testPizza1.setSize(2);
        testPizza1.setToppings(4);

        double prepTime1 = testPizza1.getPrepTime();

        System.out.println("getPrepTime() with size = 2 and toppings = 4:");
        System.out.println("Expected result: 22.0");
        System.out.println("Actual result: " + prepTime1);

        Pizza testPizza2 = new Pizza();
        testPizza2.setSize(3);
        testPizza2.setToppings(10);

        double prepTime2 = testPizza2.getPrepTime();

        System.out.println("getPrepTime() with size = 3 and toppings = 10:");
        System.out.println("Expected result: 39.0");
        System.out.println("Actual result: " + prepTime2);
        System.out.println();
    }
}
