import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrder {
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    /**
     * getPizzas returns the ArrayList of pizzas
     * @return pizzas
     */
    public ArrayList<Pizza> getPizzas(){
        
        return pizzas;

    }

    /**
     * readOrder takes in the name of a csv file and tries to create objects based on the first item in
     * each line. If the first word is "pizza", then readOrder creates a Pizza object and saves it in
     * the pizzas ArrayList.
     * Remember to use try/catch blocks when opening files. For each line in the file, create a Pizza
     * object by passing the line to the Pizza constructor and add the new object to the ArrayList. You
     * can use a while loop and a scanner to read through the enire file.
     * @param filename the name of a file
     */
    public void readOrder(String filename){
        
        try{
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                if(lineArray[0].equalsIgnoreCase("pizza")){
                    Pizza pizza = new Pizza(line);
                    pizzas.add(pizza);
                }
            }
            scan.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }

    /**
     * buildReceipt uses the getReceipt() method from Pizza to make a String containing all the
     * "receipt blocks" of all the pizzas in the pizzas arrayList. Most of this method has been
     * completed already, so you just need to fix the areas noted with //TODO Student. After each
     * item, the method will add a horizontal line of dashes to separate orders from each other.
     * @return a string containing all the receipt blocks from every item in the order.
     */
    public String buildReceipt(){
        String receipt = "--------------------\n";
        double total = 0;
        for (Pizza p : pizzas) {

            receipt += p.getReceipt();
            total += p.calculatePrice();

            receipt += "--------------------\n";
        }
        receipt += String.format("TOTAL:%14.2f\n--------------------\n",total);
        return receipt;
    }

    // public static void main(String[] args) {
    //     CustomerOrder order = new CustomerOrder();
    //     order.readOrder("/src/PizzaOrder001.csv");
    //     System.out.println(order.buildReceipt());
    // }

}
