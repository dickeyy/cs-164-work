public class Salad implements MenuItem {
    private String size;
    private String dressing;

    /**
     * The constructor for salad will create a salad object and assign the salad object with
     * two String variables: a size and a dressing.
     * @param orderLine a string in the format of "salad,size,dressing"
     */
    public Salad(String orderLine){

        // split the orderLine into an array of Strings
        String[] lineArray = orderLine.split(",");

        // assign the size and dressing variables
        size = lineArray[1];
        dressing = lineArray[2];

    }

    /**
     * getReceipt creates a String that is ready to be printed to a receipt that is
     * 20 characters wide. This will look very similar to the Pizza's getReceipt method.
     * Instead of looping through all the toppings, you will want to list the size of
     * the salad and the dressing. Make sure to end with a new line character.
     * Example:
     * SALAD          10.50
     *               MEDIUM
     *                RANCH
     *
     * @return recipt a String displaying the price of the pizza and a list of all the toppings.
     */
    @Override
    public String getReceipt() {

        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("SALAD%15.2f\n",calculatePrice()));
        receipt.append(String.format("%20s\n",size.toUpperCase()));
        receipt.append(String.format("%20s\n",dressing.toUpperCase()));
        return receipt.toString();
        
    }

    /**
     * calculatePrice calculates the price of a salad. If a salad is small, it is $8.50. A medium
     * salad is $10.50. A large salad is $12.50.
     * @return price a double that holds the cost of the pizza
     */
    @Override
    public double calculatePrice() {

        // calculate the price of the salad based on the size
        double price = 0;
        if (size.equalsIgnoreCase("small")) {
            price = 8.50;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 10.50;
        } else if (size.equalsIgnoreCase("large")) {
            price = 12.50;
        }

        // return the price
        return price;
       
    }
}