package labs.lab01;

public class Bugged {
    /**
     * This one just prints some random stuff and does some random math
     *
     * @param val
     * @param num1
     * @param num2
     */
    public static boolean printer(String val, int num1, double num2){ //4 errors
        System.out.println(val + "is my favorite color!");
        int num3 = 42;

        double num4 = num1 + num2 * num3;
        System.out.println("The number is " + num4);

        System.out.println();
        return num4 == num1 + num2 * num3;
    }

    /**
     *
     * A broken calculator with the number 3 permanently jammed and the remainder button also permanently jammed
     * This means the first value entered into the calculator is always 3
     * This also means the symbol used is always %
     *
     * @param val
     * @return Returns true at the end to indicate it could do the calculation
     */
    public static boolean jammedCalculator(int val){ //4 errors
        int jammedVal = 3;
        System.out.println("Your result is " + (jammedVal % val));
        return true;
    }

    /**
     * This is where your program actually runs everything
     *
     * @param args
     */
    public static void main(String[] args){ //4 errors
        System.out.println(printer("Indigo", 1, 4.0));
        jammedCalculator(4);
        System.out.println("Done!");
    }
}