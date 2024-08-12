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




    public static void printVictoryMessage(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }



    public static boolean compareAnswers(int userAnswer, int correctAnswer, String userName) {
        boolean result = userAnswer == correctAnswer;
        if (!result) {
            System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
        }
        return result;
    }

    public static boolean compareAnswers(String userAnswer, String correctAnswer, String userName) {
        boolean result = userAnswer.equals(correctAnswer);
        if (!result) {
            System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
        }
        return result;
    }

}
