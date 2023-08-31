package labs.lab02;
import java.util.Scanner;

public class OpenPizzaOrderingApp {

    // main logic for the app
    public static void runApp() {
        //This scanner object is used to read in values from the console.
        Scanner scnr = new Scanner(System.in);
        //This is the Pizza object we are using the duration of the app.
        Pizza pizzaObj = new Pizza(); 

        printWelcome();
        getPizzaInfo(scnr, pizzaObj);
        pizzaObj.calculateBasePizzaPrice();

        getDeliveryInfo(scnr, pizzaObj);
        getTaxInfo(scnr, pizzaObj);

        printFinalInfo(pizzaObj);

        scnr.close();
    }

    // prints welcome stuff
    public static void printWelcome() {
        System.out.println("--------------------------------------");
        System.out.println("Welcome to the Open Pizza Ordering App");
        System.out.println("--------------------------------------");
    }

    // asks the user the size and num toppings, sets them
    public static void getPizzaInfo(Scanner scnr, Pizza pizzaObj) {
        System.out.println("What size pizza would you like? (1-3)");
        int size = scnr.nextInt();
        pizzaObj.setSize(size); 

        System.out.println("How many toppings would you like? (1-10)");
        int toppings = scnr.nextInt();
        pizzaObj.setToppings(toppings);
    }
    
    // do they want delivery?
    public static void getDeliveryInfo(Scanner scnr, Pizza pizzaObj) {
        System.out.println("Would you like this pizza to be delivered? (0 for No, 1 for Yes)");
        int delivery = scnr.nextInt();
        pizzaObj.addDeliveryFee(delivery);
    }

    // i hate tax 
    public static void getTaxInfo(Scanner scnr, Pizza pizzaObj) {
        System.out.println("What is the tax rate in your area? (0-20)");
        int taxRate = scnr.nextInt();
        pizzaObj.addPizzaTax(taxRate);
    }

    // gotta give them a price and estimate!
    public static void printFinalInfo(Pizza pizzaObj) {
        System.out.println("You have ordered a size " + pizzaObj.pizzaSize + " pizza, with " + pizzaObj.numToppings + " toppings.");
        
        double price = pizzaObj.getPizzaPrice();
        //The below line rounds our price to two decimal places
        double roundedPrice = Math.round(price * 100.0) / 100.0;

        System.out.println("The final price comes out to " + roundedPrice);
        System.out.println();
        System.out.println("Your pizza will take " + pizzaObj.getPrepTime() + " minutes to be ready,");
        System.out.println("for pickup or the beginning of delivery!");
        System.out.println();
        System.out.println("Thank you for using the Open Pizza Ordering App!");
    }

    public static void main(String[] args) {
        runApp();

        // PizzaTester tester = new PizzaTester();
        // tester.testCalculateBasePizzaPrice();
        // tester.testAddDeliveryFee();
        // tester.testAddPizzaTax();
        // tester.testGetPrepTime();
    }
}
