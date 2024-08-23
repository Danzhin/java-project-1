package hexlet.code.games;

import hexlet.code.Utils;
import hexlet.code.GameData;
import hexlet.code.Engine;
import java.util.Scanner;

public class Even {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 10;
    private static final int MAX_NUMBER = 100;

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String createQuestion(int number) {
        return "Question: " + number;
    }

    private static String getCorrectAnswer(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            int number = Utils.createRandomNumber(MIN_NUMBER, MAX_NUMBER);

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
