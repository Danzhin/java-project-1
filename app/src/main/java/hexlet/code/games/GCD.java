package hexlet.code.games;

import hexlet.code.GameData;
import java.util.Scanner;

import static hexlet.code.Engine.startGame;

public class GCD {

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

    private static GameData createGameData(int countRounds) {
        String rules = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[countRounds];
        String[] correctAnswers = new String[countRounds];

        int number1;
        int number2;
        for (int i = 0; i < countRounds; i++) {
            number1 = (int) (Math.random() * 10 + 2);
            number2 = (int) (Math.random() * 10 + 2);
            questions[i] = createQuestion(number1, number2);
            correctAnswers[i] = createCorrectAnswer(number1, number2);
        }

        return new GameData(countRounds, rules, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner, int countRounds) {
        GameData gameData = createGameData(countRounds);
        startGame(userName, gameData, scanner);
    }

}
