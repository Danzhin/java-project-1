package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static String getUserAnswer(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.next();
    }

    private static boolean compareAnswers(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    public static void startGame(String userName, GameData gameData, Scanner scanner) {
        System.out.println(gameData.rules());

        String userAnswer;
        String correctAnswer;

        for (int i = 0; i < gameData.countRound(); i++) {
            System.out.println(gameData.questions()[i]);

            userAnswer = getUserAnswer(scanner);
            correctAnswer = gameData.correctAnswers()[i];

            if (!compareAnswers(userAnswer, correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }

}
