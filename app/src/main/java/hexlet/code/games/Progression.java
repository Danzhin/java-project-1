package hexlet.code.games;

import hexlet.code.GameData;
import java.util.Scanner;

import static hexlet.code.Engine.startGame;

public class Progression {

    private static String createQuestion(int[] progression, int indexMissedNumber) {
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            question.append(i == indexMissedNumber ? ".. " : progression[i] + " ");
        }
        return question.toString();
    }

    private static int[] createProgression(int size) {
        int[] progression = new int[size];
        int number = (int) (Math.random() * 10) + 1;
        int step = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < size; i++) {
            number += step;
            progression[i] = number;
        }
        return progression;
    }

    private static GameData createGameData(int countRounds) {
        String rules = "What number is missing in the progression?";
        String[] questions = new String[countRounds];
        String[] correctAnswers = new String[countRounds];

        int size = 5;
        int indexMissedNumber = 0;
        int[]  progression = createProgression(size);
        for (int i = 0; i < countRounds; i++) {
            questions[i] = createQuestion(progression, indexMissedNumber);
            correctAnswers[i] = Integer.toString(progression[indexMissedNumber]);
            indexMissedNumber += 2;
        }
        return new GameData(countRounds, rules, questions, correctAnswers);
    }

    public static void play(String userName, Scanner scanner, int countRounds) {
        GameData gameData = createGameData(countRounds);
        startGame(userName, gameData, scanner);
    }

}
