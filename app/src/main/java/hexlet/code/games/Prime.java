package hexlet.code.games;

import hexlet.code.GameData;
import java.util.Scanner;

import static hexlet.code.Engine.startGame;

public class Prime {

    private static String createQuestion(int number) {
        return "Question: " + number;
    }

    private static String createCorrectAnswer(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    private static GameData createGameData(int countRounds) {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[countRounds];
        String[] correctAnswers = new String[countRounds];

        int number;
        for (int i = 0; i < countRounds; i++) {
            number = (int) (Math.random() * 50 + 1);
            questions[i] = createQuestion(number);
            correctAnswers[i] = createCorrectAnswer(number);
        }

        return new GameData(countRounds, rules, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner, int countRounds) {
        GameData gameData = createGameData(countRounds);
        startGame(userName, gameData, scanner);
    }

}