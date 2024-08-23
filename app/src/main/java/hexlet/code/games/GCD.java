package hexlet.code.games;

import hexlet.code.GameData;
import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;

public class GCD {

    private static final String RULES = "Find the greatest common divisor of given numbers.";

    private static final int MIN_NUMBER = 10;
    private static final int UPPER_LIMIT_NUMBER = 50;

    private static int calculateGCD(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }

    private static String createQuestion(int number1, int number2) {
        return "Question: " + number1 + " " + number2;
    }

    private static String getCorrectAnswer(int number1, int number2) {
        return Integer.toString(calculateGCD(number1, number2));
    }

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int number1 = Utils.createRandomNumber(MIN_NUMBER, UPPER_LIMIT_NUMBER);
            int number2 = Utils.createRandomNumber(MIN_NUMBER, UPPER_LIMIT_NUMBER);

            questions[i] = createQuestion(number1, number2);
            correctAnswers[i] = getCorrectAnswer(number1, number2);
        }

        return new GameData(RULES, Engine.COUNT_ROUNDS, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
