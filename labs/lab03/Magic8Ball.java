package labs.lab03;

import java.util.Random;
import java.util.Scanner;

public class Magic8Ball {
    Random roller = new Random();
    Scanner input = new Scanner(System.in);

    /**
     * For this method, you will be deciding which kind of answer the user will get depending on what magicNum is.
     * if magicNum is divisible by 3, call positiveAnswer to get your result
     * else if magic num is divisible by 2, call negativeAnswer to get your result
     * else, call neutralAnswer to get your result
     *
     * The first if statement is done for you.
     *
     * @param magicNum
     * @return the string that will result from calling one of the helper methods
     */
    public String decidePolarity(int magicNum) {
        if (magicNum % 3 == 0){
            return positiveAnswer(magicNum);
        } else if (magicNum % 2 == 0) {
            return negativeAnswer(magicNum);
        } else {
            return neutralAnswer(magicNum);
        }
    }

    /**
     * For this method, you will decide which positive message to return depending on the following conditions:
     * if magicNum is less than 12, return "You may rely on it."
     * if magicNum is equal to 12, return "As I see it, yes."
     * if magicNum is 13-27 (inclusive), return "Signs point to yes."
     * if magicNum is between 27-78 (exclusive), return "Outlook good."
     * if magic num is 78 or greater, return "Without a doubt."
     *
     * The first if-statement has been done for you
     *
     * @param magicNum
     * @return the appropriate string for the conditions
     */
    public String positiveAnswer(int magicNum){
        if (magicNum < 12){
            return "You may rely on it.";
        } else if (magicNum == 12) {
            return "As I see it, yes.";
        } else if (magicNum >= 13 && magicNum <= 27) {
            return "Signs point to yes.";
        } else if (magicNum > 27 && magicNum < 78) {
            return "Outlook good.";
        } else if (magicNum >= 78) {
            return "Without a doubt.";
        } else {
            return "";
        }
    }

    /**
     *  For this method, you will decide which negative message to return depending on the following conditions:
     *  if magicNum is less than 5, return "Very doubtful"
     *  if magicNum is equal to 5, return "Don't count on it."
     *  if magicNum is 6-43 (inclusive), return "My reply is no."
     *  if magicNum is between 43-89 (exclusive), return "My sources say no."
     *  if magic num is 89 or greater, return "Outlook not so good."
     *
     *  The first if-statement has been done for you
     *
     * @param magicNum
     * @return the appropriate string for the conditions
     */
    public String negativeAnswer(int magicNum){
        if (magicNum < 5){
            return "Very doubtful";
        } else if (magicNum == 5) {
            return "Don't count on it.";
        } else if (magicNum >= 6 && magicNum <= 43) {
            return "My reply is no.";
        } else if (magicNum > 43 && magicNum < 89) {
            return "My sources say no.";
        } else if (magicNum >= 89) {
            return "Outlook not so good.";
        } else {
            return "";
        }
    }

    /**
     * For this method, you will decide which neutral message to return depending on the following conditions:
     * if magicNum is less than 22, return "Concentrate and ask again."
     * if magicNum is equal to 22, return "Reply hazy, try again."
     * if magicNum is 23-35 (inclusive), return "Ask again later."
     * if magicNum is between 35-62 (exclusive), return "Better not tell you now."
     * if magic num is 62 or greater, return "Cannot predict now."
     *
     * The first if-statement has been done for you
     *
     * @param magicNum
     * @return the appropriate string for the conditions
     */
    public String neutralAnswer(int magicNum){
        if (magicNum < 22){
            return "Concentrate and ask again.";
        } else if (magicNum == 22) {
            return "Reply hazy, try again.";
        } else if (magicNum >= 23 && magicNum <= 35) {
            return "Ask again later.";
        } else if (magicNum > 35 && magicNum < 62) {
            return "Better not tell you now.";
        } else if (magicNum >= 62) {
            return "Cannot predict now.";
        } else {
            return "";
        }
    }

    public String requestInput() {
        return "Hello! Are you ready to have your future read? (y/n) ";
    }
    public void go(){
        System.out.println(requestInput());
        String answer = input.nextLine();
        while (!answer.equalsIgnoreCase("n")){
            System.out.println("Now think of a question to yourself. When you're ready, press enter.");
            input.nextLine();
            int magicNumber = roller.nextInt(100);
            System.out.println(decidePolarity(magicNumber));
            System.out.println("Would you like to go again? (y/n) ");
            answer = input.nextLine();
        }
    }

    public static void main(String[] args){
        Magic8Ball magic8 = new Magic8Ball();
        magic8.go();
    }
}