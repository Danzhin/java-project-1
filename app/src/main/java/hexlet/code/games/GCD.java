package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;
import java.util.Scanner;

public class GCD {

    private static final String RULES = "Find the greatest common divisor of given numbers.";

    private static final int UPPER_LIMIT_NUMBER = 10;

    private static String createQuestion(int number1, int number2) {
        return "Question: " + number1 + " " + number2;
    }

    private static String createCorrectAnswer(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return Integer.toString(number1);
    }

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        int number1;
        int number2;
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            number1 = (int) (Math.random() * UPPER_LIMIT_NUMBER + 1);
            number2 = (int) (Math.random() * UPPER_LIMIT_NUMBER + 1);
            questions[i] = createQuestion(number1, number2);
            correctAnswers[i] = createCorrectAnswer(number1, number2);
        }

        return new GameData(RULES, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
