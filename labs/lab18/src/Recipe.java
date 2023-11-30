public class Recipe {
    String name;
    String[][] recipe;

    /**
     * Creates a 2D array with the ingredients needed to craft the object and saves the name of the object
     */
    public Recipe(String name, String[] ingredients){
        this.name = name;
        this.recipe = new String[3][3];
        
        int index = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (ingredients[index].equals("X")){
                    ingredients[index] = "";
                }
                recipe[i][j] = ingredients[index];
                index++;
            }
        }
    }
}
