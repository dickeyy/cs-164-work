package labs.lab03;

public class Magic8BallTests {
    // test the magic 8 ball with a range of numbers
    public static void main(String[] args) {
        Magic8Ball ball = new Magic8Ball();

        int magicNum = 1;
        String result = ball.decidePolarity(magicNum);
        String expected = "You may rely on it.";

        System.out.println("Testing decidePolarity with " + magicNum);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + result);
        
        // determine if the test passed
        if (result.equals(expected)) {
            System.out.println("PASSED TEST\n\n");
        } else {
            System.out.println("FAILED TEST");
        }
    }
}
