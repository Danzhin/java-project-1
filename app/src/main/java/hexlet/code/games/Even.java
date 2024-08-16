package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;
import java.util.Scanner;

public class Even {

    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int UPPER_LIMIT_NUMBER = 100;

    private static String createQuestion(int number) {
        return "Question: " + number;
    }

    private static String createCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    private static GameData createGameData(String[] questions, String[] correctAnswers) {
        int number;
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            number = (int) (Math.random() * UPPER_LIMIT_NUMBER + 1);
            questions[i] = createQuestion(number);
            correctAnswers[i] = createCorrectAnswer(number);
        }

        return new GameData(RULES, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData(new String[Engine.COUNT_ROUNDS], new String[Engine.COUNT_ROUNDS]);
        Engine.startGame(userName, gameData, scanner);
    }

}
