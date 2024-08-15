package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameData;
import java.util.Scanner;

public class Progression {

    private static final String RULES = "What number is missing in the progression?";

    private static final int PROGRESSION_SIZE = 10;

    private static final int UPPER_LIMIT_FIRST = 100;

    private static final int UPPER_LIMIT_DIFFERENCE = 10;

    private static String createQuestion(int first, int difference, int indexMissedNumber) {
        StringBuilder question = new StringBuilder();
        question.append("Question: ");
        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            question.append(i == indexMissedNumber ? ".. " : first + i * difference  + " ");
        }
        return question.toString();
    }

    private static String createCorrectAnswer(int first, int difference, int indexMissedNumber) {
        return Integer.toString(first + difference * indexMissedNumber);
    }

    private static GameData createGameData() {
        String[] questions = new String[Engine.COUNT_ROUNDS];
        String[] correctAnswers = new String[Engine.COUNT_ROUNDS];

        int first;
        int difference;
        int indexMissedNumbe;
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            first = (int) (Math.random() * UPPER_LIMIT_FIRST + 1);
            difference = (int) (Math.random() * UPPER_LIMIT_DIFFERENCE + 1);
            indexMissedNumbe = (int) (Math.random() * PROGRESSION_SIZE);
            questions[i] = createQuestion(first, difference, indexMissedNumbe);
            correctAnswers[i] = createCorrectAnswer(first, difference, indexMissedNumbe);
        }
        return new GameData(RULES, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
