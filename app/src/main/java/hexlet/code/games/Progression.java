package hexlet.code.games;

import hexlet.code.GameData;
import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;

public class Progression {

    private static final String RULES = "What number is missing in the progression?";

    private static final int COUNT_ROUNDS = Engine.COUNT_ROUNDS;

    private static final int PROGRESSION_SIZE = 10;

    private static final int MIN_FIRST = 10;
    private static final int MAX_FIRST = 50;

    private static final int MIN_DIFFERENCE = 3;
    private static final int MAX_DIFFERENCE = 9;

    private static int findMissingNumber(int[] progression, int indexMissedNumber) {
        return progression[indexMissedNumber];
    }

    private static String createQuestion(int[] progression, int indexMissedNumber) {
        StringBuilder question = new StringBuilder();
        question.append("Question: ");
        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            question.append(i == indexMissedNumber ? ".. " : progression[i]  + " ");
        }
        return question.toString();
    }

    private static String getCorrectAnswer(int[] progression, int indexMissedNumber) {
        return Integer.toString(findMissingNumber(progression, indexMissedNumber));
    }

    private static GameData createGameData() {
        String[] questions = new String[COUNT_ROUNDS];
        String[] correctAnswers = new String[COUNT_ROUNDS];
        final int[] indexesMissingNumbers = {2, 5, 8};

        for (int i = 0; i < COUNT_ROUNDS; i++) {
            int first = Utils.createRandomNumber(MIN_FIRST, MAX_FIRST);
            int difference = Utils.createRandomNumber(MIN_DIFFERENCE, MAX_DIFFERENCE);
            int[] progression = Utils.createProgression(PROGRESSION_SIZE, first, difference);

            questions[i] = createQuestion(progression, indexesMissingNumbers[i % COUNT_ROUNDS]);
            correctAnswers[i] = getCorrectAnswer(progression, indexesMissingNumbers[i % COUNT_ROUNDS]);
        }

        return new GameData(RULES, COUNT_ROUNDS, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner) {
        GameData gameData = createGameData();
        Engine.startGame(userName, gameData, scanner);
    }

}
