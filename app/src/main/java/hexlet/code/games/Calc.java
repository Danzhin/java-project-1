package hexlet.code.games;

import hexlet.code.GameData;
import java.util.Scanner;

import static hexlet.code.Engine.startGame;

public class Calc {

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

    private static GameData createGameData(int countRounds) {
        String rules = "What is the result of the expression?";
        String[] questions = new String[countRounds];
        String[] correctAnswers = new String[countRounds];

        int number1;
        int number2;
        String[] operations = {"+", "-", "*"};
        for (int i = 0; i < countRounds; i++) {
            number1 = (int) (Math.random() * 20 + 1);
            number2 = (int) (Math.random() * 10 + 1);
            questions[i] = createQuestion(number1, number2, operations[i]);
            correctAnswers[i] = createCorrectAnswer(number1, number2, operations[i]);
        }

        return new GameData(countRounds, rules, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner, int countRounds) {
        GameData gameData = createGameData(countRounds);
        startGame(userName, gameData, scanner);
    }

}
