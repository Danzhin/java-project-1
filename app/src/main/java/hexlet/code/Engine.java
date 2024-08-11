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

    public static boolean compareAnswers(int userAnswer, int correctAnswer) {
        return userAnswer == correctAnswer;
    }

    public static boolean compareAnswers(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    public static void errorMessage(int userAnswer, int correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
    }

    public static void errorMessage(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
    }

    public static void printVictoryMessage(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void printLossMessage(String userName) {
        System.out.println("Let's try again, " + userName + "!");
    }

}
