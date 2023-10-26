import java.util.ArrayList;

public class Pizza implements MenuItem {
    public ArrayList<String> toppings = new ArrayList<String>();

    /**
     * The constructor for a Pizza object takes in a comma separated string such as:
     * "Pizza,pepperoni,mushrooms,sausage". The constructor has to add each topping
     * and add it to the toppings ArrayList.
     *
     * @param orderLine a string in the format of "Pizza,topping,topping,topping,topping..."
     */
    public Pizza(String orderLine){
        String toppingString = orderLine.substring(orderLine.indexOf(',')+1);
        while(toppingString.contains(",")){
            int commaIndex = toppingString.indexOf(",");
            String topping = toppingString.substring(0,commaIndex);

            toppings.add(topping);
            toppingString = toppingString.substring(commaIndex+1);
        }

        toppings.add(toppingString);
    }

    /**
     * getReceipt creates a String that is ready to be printed to a receipt that is
     * 20 characters wide.
     * @return recipt a String displaying the price of the pizza and a list of all the toppings.
     */
    @Override
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("PIZZA%15.2f\n",calculatePrice()));
        for(String topping : toppings){
            receipt.append(String.format("%20s\n",topping.toUpperCase()));
        }
        return receipt.toString();
    }

    /**
     * calculatePrice calculates the price of a pizza. A pizza's initial cost is $9.99 and each
     * additional topping costs and extra $1.49.
     * @return price a double that holds the cost of the pizza
     */
    @Override
    public double calculatePrice() {
        double price = 9.99;
        double toppingCharge = 1.49;
        price = price + toppingCharge * toppings.size();
        return price;
    }

}