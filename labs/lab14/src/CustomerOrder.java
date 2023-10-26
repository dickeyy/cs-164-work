import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrder {
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private ArrayList<Salad> salads = new ArrayList<Salad>();

    /**
     * getPizzas returns the ArrayList of pizzas
     * @return pizzas
     */
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }

    /**
     * getSalads returns the ArrayList of salads
     * @return salads
     */
    public ArrayList<Salad> getSalads(){
        return salads;
    }

    /**
     * readOrder takes in the name of a csv file and tries to create objects based on the first item in
     * each line. If the first word is "pizza" of "cookie pizza", then readOrder creates a Pizza object 
     * and saves it in the pizzas ArrayList. If the first word is "salad", then a Salad object is made 
     * and stored in  an ArrayList called "salads". You will have to make this new arrayList.
     * In the csv file, a pizza will look like "pizza,pepperoni,tomatoes,onions"
     * A salad will look like "salad,medium,ranch"
     * A cookie pizza will look like "cookie pizza,chocolate chip,strawberries,cinnamon".
     * Because a cookie pizza IS a Pizza (through inheritance), do we need to make a new ArrayList for
     * CookiePizza objects, or can we add them to the pizzas ArrayList?
     * @param filename the name of a file
     */
    public void readOrder(String filename){
        try{
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                if (lineArray[0].equalsIgnoreCase("pizza")){
                    Pizza pizza = new Pizza(line);
                    pizzas.add(pizza);
                }
                else if (lineArray[0].equalsIgnoreCase("salad")){
                    Salad salad = new Salad(line);
                    salads.add(salad);
                }
                else if (lineArray[0].equalsIgnoreCase("cookie pizza")){
                    CookiePizza cookiePizza = new CookiePizza(line);
                    pizzas.add(cookiePizza);
                }
            }
            scan.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    /**
     * toString is the method that is called whenever an object is printed. If we were to write
     * System.out.println(customerOrder1), then the customerOrder1.toString() method would be
     * called. We will want this method to return the result of buildReceipt(). This way, we
     * don't have to write System.out.println(customerOrder1.buildReceipt()) anymore, just
     * System.out.println(customerOrder1).
     * @return the result of buildReceipt()
     */
    public String toString(){
        
        return buildReceipt();

    }

    /**
     * buildReceipt should require no changes if you correctly added your new CookiePizza objects
     * to the Pizza ArrayList!
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

        for (Salad s : salads) {

            receipt += s.getReceipt();
            total += s.calculatePrice();

            receipt += "--------------------\n";
        }

        receipt += String.format("TOTAL:%14.2f\n--------------------",total);
        return receipt;
    }

    /**
     * printReceipt should require no changes!
     * @param fileName the name of the file to print to.
     */
    public void printReceipt(String fileName){
        try{
            PrintWriter writer = new PrintWriter(fileName);
            writer.println(buildReceipt());
            writer.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}