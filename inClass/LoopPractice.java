public class LoopPractice {
    public static void main(String[] args) {
        // make a loop that prints the first 100 even numbers

        int i = 0;
        int numOfEvens = 0;
        while (i <= 200) {
            if (i % 2 == 0) {
                System.out.println(i);
                numOfEvens++;
            }

            i++;
        }

        System.out.println("There are " + numOfEvens + " even numbers");
    }
}
