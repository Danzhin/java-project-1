package hexlet.code.games;

import hexlet.code.GameData;
import java.util.Scanner;

import hexlet.code.Engine;

public class Calc {

    private static final String RULES = "What is the result of the expression?";

    private static String createQuestion(int number1, int number2, String operation) {
        return "Question: " + number1 + " " + operation + " " + number2;
    }

    private static String createCorrectAnswer(int number1, int number2, String operation) {
        return switch (operation) {
            case "+" -> Integer.toString(number1 + number2);
            case "-" -> Integer.toString(number1 - number2);
            default -> Integer.toString(number1 * number2);
        };
    }

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        int number1;
        int number2;
        final String[] operations = {"+", "-", "*"};

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            number1 = (int) (Math.random() * 20 + 1);
            number2 = (int) (Math.random() * 10 + 1);
            questions[i] = createQuestion(number1, number2, operations[i % 3]);
            correctAnswers[i] = createCorrectAnswer(number1, number2, operations[i % 3]);
        }

        return new GameData(RULES, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
