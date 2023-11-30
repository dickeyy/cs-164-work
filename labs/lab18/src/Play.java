import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Play {
    String[][] craftingTable;
    Scanner input;
    CraftingTable crafting;
    Recipes recipeBook;

    public Play(String filename) {
        craftingTable = new String[3][3];
        input = new Scanner(System.in);
        crafting = new CraftingTable();

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                craftingTable[i][j] = "";
            }
        }
        recipeBook = new Recipes(filename);
    }

    /**
     * returns a string containing the options
     */
    public static String options(){
        return  "A: Add Item\n" +
                "R: Remove Item\n" +
                "V: View Crafting Table\n" +
                "C: Craft\n" +
                "P: Recipes\n" +
                "X: Exit\n" +
                "Please enter the letter for your option.";
    }

    /**
     * gets the item, row, and column, then calls the AddItem function
     */
    public void add(){
        System.out.println("What would you like to add?");
        String item = input.nextLine();
        System.out.println("Where would you like to add it?\nRow: ");
        int row = Integer.parseInt(input.nextLine());
        System.out.println("Column: ");
        int column = Integer.parseInt(input.nextLine());
        crafting.addItem(craftingTable, item, row, column);
    }

    /**
     * gets the item to be removed, then calls the Remove function
     */
    public void remove(){
        System.out.println("What item would you like to remove?");
        String item = input.nextLine();
        crafting.removeItem(craftingTable, item);
    }

    /**
     * prints the crafting table
     */
    public void view(String[][] table){
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        for (String[] rows : table){
            System.out.print("| ");
            for(String column : rows){
                System.out.print(column + " | ");
            }
            System.out.println();
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        }
    }

    /**
     * prints information in different recipes
     */
    public void recipeList(){
        System.out.println("The Recipes are as Follows: ");
        int counter = 1;
        for (Recipe r : recipeBook.recipes){
            System.out.println(String.format("%d: %s", counter, r.name));
            counter++;
        }
        System.out.println("Please enter the number of the recipe you would like to see: ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        view(recipeBook.recipes.get(index).recipe);

    }

    /**
     * attempts to craft an item using the recipe book and the current crafting table
     */
    public String craft(){
        for (Recipe r : recipeBook.recipes){
            if (Arrays.deepEquals(r.recipe, craftingTable)){
                return "You Crafted: " + r.name;
            }
        }
        return "Recipe not found!";
    }

    public void PlayGame(){
        System.out.println("Welcome to the Crafting Table Simulator!\nWhat would you like to do?");
        while (true){
            System.out.println(options());
            String userInput = input.nextLine();
            if(userInput.equalsIgnoreCase("a")){ //add item
                add();
            }
            else if(userInput.equalsIgnoreCase("r")){ //remove item
                remove();
            }
            else if (userInput.equalsIgnoreCase("v")){ //view table
                    view(craftingTable);
            }
            else if (userInput.equalsIgnoreCase("c")){ //craft
                    System.out.println(craft());
            }
            else if (userInput.equalsIgnoreCase("p")){ //display recipes
                recipeList();
            }
            else if (userInput.equalsIgnoreCase("x")){ //exit
                break;
            }
            else{
                continue;
            }
        }
        System.out.println("Happy Crafting!!");
    }


    public static void main(String[] args) throws FileNotFoundException {
        Play craft = new Play("./labs/lab18/src/recipes.txt"); //this loads up the recipes file for our crafting and starts the program
        craft.PlayGame();
    }
}
