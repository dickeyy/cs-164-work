package labs.lab04;

public class Coffee {
    String[] syrups;
    String size;
    String typeVal;

    public Coffee(char size, int type, String[] syrups){
        // This is where you will put your switch statements for size and type

        // size switch statement
        switch (size) {
            case 's':
                this.size = "small";
                break;
            case 'm':
                this.size = "medium";
                break;
            case 'l':
                this.size = "large";
                break;
            default:
                this.size = "medium";
                break;
        }

        // type switch statement
        switch (type) {
            case 1:
                this.typeVal = "iced";
                break;
            case 2:
                this.typeVal = "blended";
                break;
            case 3:
                this.typeVal = "hot";
                break;
            default:
                this.typeVal = "hot";
                break;
        }
      
        // provided
        this.syrups = new String[syrups.length];
        for(int i = 0; i < syrups.length; i++){
            this.syrups[i] = syrups[i];
        }
    }

  // this function returns the size of the drink
    public String getSize(){
        // return the size of the drink
        return this.size;
    }

   //this function returns the type of the drink
    public String getType(){
        return this.typeVal;
    }

   //this function returns the syrups in the drink
    public String[] getSyrups(){
        return this.syrups;
    }

   //this function sets the type of the drink
    public void setType(String typ){
        this.typeVal = typ;
    }

  //this function sets the size of the drink
   public void setSize(String siz){
        this.size = siz;
    }

  //this function sets the syrups for the drink
  public void setSyrups(String[] syrup){  
        this.syrups = new String[syrup.length];
        for(int i = 0; i < syrup.length; i++){
            this.syrups[i] = syrup[i];
        }
    }

  //This function will return the total price of the drink, considering size, type, and syrups
  public double calculatePrice() {
        double price = 0.0;

        // write if statements for size and type
        if (this.size.equals("small")) {
            price += 3.0;
        } else if (this.size.equals("medium")) {
            price += 4.0;
        } else if (this.size.equals("large")) {
            price += 5.0;
        }

        for (String syrup : syrups) {
            if (syrup.equals("chocolate") || syrup.equals("vanilla") || syrup.equals("caramel")) {
                price += 0.0;
            } else {
                price += 0.5;
            }
        }
        return price;
    }


    public static void main(String[] args){ 

        // Test your code here to make sure it works
        String[] temp = {"caramel", "chocolate"};
        Coffee myOrder = new Coffee('s', 1, temp);
        System.out.println("TESTING CONSTRUCTOR SIZE: " + myOrder.size); // should return "small" -- passed
        System.out.println("TESTING CONSTRUCTOR TYPE: " + myOrder.typeVal); // should return "iced" -- failed
        System.out.println("TESTING CONSTRUCTOR SYRUPS: " + myOrder.syrups[0] + " " + myOrder.syrups[1]); // should return "caramel chocolate" -- passed
        System.out.println("TESTING GET SIZE: " + myOrder.getSize()); // should return "small" -- passed
        System.out.println("TESTING GET TYPE: " + myOrder.getType()); // should return "iced" -- failed
        System.out.println("TESTING GET SYRUPS: " + myOrder.getSyrups()[0] + " " + myOrder.getSyrups()[1]); // should return "caramel chocolate"
        myOrder.setSize("medium");
        System.out.println("TESTING GET SIZE: " + myOrder.getSize()); // should return "medium"
        myOrder.setType("hot");
        System.out.println("TESTING GET TYPE: " + myOrder.getType()); // should return "hot"
        String[] temp2 = {"chocolate", "mint", "lavender"};
        myOrder.setSyrups(temp2);
        System.out.println("TESTING GET SYRUPS: " + myOrder.getSyrups()[0] + " " + myOrder.getSyrups()[1] + " " + myOrder.getSyrups()[2]); // should return "chocolate mint lavender"
        System.out.println("TESTING PRICE: " + myOrder.calculatePrice()); // should return 4.0

    }
}