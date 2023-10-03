import java.util.Scanner;

public class TokenCounter {
    public static void main(String[] args) {
        String line = "This is a message\nComposed by\nThree lines";
        Scanner scanner = new Scanner(line);
        int token = 0;
        while (scanner.hasNext()) {
            token ++;
            System.out.println(scanner.nextLine());
        }
        System.out.println(token);
    }
}
