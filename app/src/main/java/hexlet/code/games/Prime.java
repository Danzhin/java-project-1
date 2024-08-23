package hexlet.code.games;

import hexlet.code.GameData;
import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;

public class Prime {

    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MIN_NUMBER = 2;
    private static final int UPPER_LIMIT_NUMBER = 50;

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String createQuestion(int number) {
        return "Question: " + number;
    }

    private static String getCorrectAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int number = Utils.createRandomNumber(MIN_NUMBER, UPPER_LIMIT_NUMBER);

            questions[i] = createQuestion(number);
            correctAnswers[i] = getCorrectAnswer(number);
        }

        return new GameData(RULES, Engine.COUNT_ROUNDS, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
