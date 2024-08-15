package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;
import java.util.Scanner;

public class Prime {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int UPPER_LIMIT_NUMBER = 50;

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

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        int number;
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            number = (int) (Math.random() * UPPER_LIMIT_NUMBER + 1);
            questions[i] = createQuestion(number);
            correctAnswers[i] = createCorrectAnswer(number);
        }

        return new GameData(RULES, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
