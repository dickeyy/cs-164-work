public class MoreRecursionHelper {
    /**
     * Converts any decimal to binary
     * 
     * 
     */
    public int toBinary(int toConvert) {
        // This method will convert any normal decimal number to its binary representation, so a number like 17 should return 10001. If you forget what binary numbers are or how they are read, there is a section within your zyBooks on the subject. This method can be deceivingly simple, but you will need to use operators such as modulo, and don't forget about PEMDAS!

        // Base case
        if (toConvert == 0) {
            return 0;
        }

        // Recursive case
        return (toConvert % 2) + 10 * toBinary(toConvert / 2);

    }

    /**
     * Takes a  parameter of rows of blocks and returns the total number of blocks
     * 
     * 
     */
    public int pyramidTotal(int rows) {
        // This method takes a parameter of however many rows of "blocks" our imaginary pyramid is made up of. Each row is made up "blocks" equal to the row number, so row 1 would have 1 block and row 12 would have 12 blocks. You will want to recursively calculate how many total "blocks" make up a pyramid given the rows. For example, 3 would return the sum of 1, 2, and 3, which is 6 and 12 would return 78.

        // Base case
        if (rows == 0) {
            return 0;
        }

        // Recursive case
        return rows + pyramidTotal(rows - 1);
    }

    /**
     * takes a String and prints all possible combinations of the characters
     * 
     * 
     */
    public void combinations(String str, int index, String currStr) {
        // Base case: if the current index is equal to the length of the input string,
        // print the current combination and return.
        if (index == str.length() - 1) {
            System.out.println(currStr);
            return;
        }
    
        // Recursive case 1: include the current character at the index in the combination.
        combinations(str, index + 1, currStr + str.charAt(index + 1));
    
        // Recursive case 2: exclude the current character at the index from the combination.
        combinations(str, index + 1, currStr);
    }
}