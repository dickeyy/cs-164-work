public class CraftingTable {
    /**
     * This function should put the item in the table at the provided row and column
     *
     * @param table  2D array you are putting the item in
     * @param item   the name of the item you are putting in the table
     * @param row    row index
     * @param column column index
     * @return the updated table
     */
    public String[][] addItem(String[][] table, String item, int row, int column) {

        // add the item to the table
        table[row][column] = item;

        // return the new table
        return table;

    }

    /**
     * This function should remove the first instance of the item it is looking for
     * and then stop
     *
     * @param table 2D array you are searching
     * @param item  the name of the item you are removing
     * @return the updated table
     */
    public String[][] removeItem(String[][] table, String item) {

        // remove the item from the table
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j].equals(item)) {
                    table[i][j] = "";
                    return table;
                }
            }
        }

        // return the new table
        return table;

    }

}
