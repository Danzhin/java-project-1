package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int COUNT_ROUNDS = 3;

    public static void startGame(String userName, GameData gameData, Scanner scanner) {
        System.out.println(gameData.rules());

        String userAnswer;
        String correctAnswer;

        for (int i = 0; i < COUNT_ROUNDS; i++) {
            System.out.println(gameData.questions()[i]);

            System.out.print("Your answer: ");
            userAnswer = scanner.next();
            correctAnswer = gameData.correctAnswers()[i];

            if (!userAnswer.equals(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");

        }
        System.out.println("Congratulations, " + userName + "!");

    }

}
