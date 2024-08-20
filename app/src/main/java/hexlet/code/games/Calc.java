package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.GameData;
import hexlet.code.Engine;
import java.util.Scanner;

public class Calc {

    private static final String RULES = "What is the result of the expression?";

    private static final int COUNT_ROUNDS = Engine.COUNT_ROUNDS;

    private static final int MIN_NUMBER = 10;
    private static final int MAX_NUMBER = 20;

    private static int calculate(int number1, int number2, String operation) {
        return switch (operation) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            default -> Integer.MAX_VALUE;
        };
    }

    private static String createQuestion(int number1, int number2, String operation) {
        return "Question: " + number1 + " " + operation + " " + number2;
    }

    private static String getCorrectAnswer(int number1, int number2, String operation) {
        return Integer.toString(calculate(number1, number2, operation));
    }

    private static GameData createGameData() {
        String[] questions = new String[COUNT_ROUNDS];
        String[] correctAnswers = new String[COUNT_ROUNDS];
        final String[] operations = {"+", "-", "+"};

        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int number1 = Utils.createRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int number2 = Utils.createRandomNumber(MIN_NUMBER, MAX_NUMBER);

            questions[i] = createQuestion(number1, number2, operations[i % operations.length]);
            correctAnswers[i] = getCorrectAnswer(number1, number2, operations[i % operations.length]);
        }

        return new GameData(RULES, COUNT_ROUNDS, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
