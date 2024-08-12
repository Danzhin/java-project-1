package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static String greeting(Scanner scanner) {
       System.out.println("Welcome to the Brain Games!");
       System.out.print("May I have your name? ");
       String userName = scanner.next();
       System.out.println("Hello, " + userName + "!");
       return userName;
    }

    public static boolean compareAnswers(int userAnswer, int correctAnswer, String userName) {
        boolean differ = userAnswer != correctAnswer;
        if (differ) {
            System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
        }
        return differ;
    }

    public static boolean compareAnswers(String userAnswer, String correctAnswer, String userName) {
        boolean differ = !userAnswer.equals(correctAnswer);
        if (differ) {
            System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
        }
        return differ;
    }

}
