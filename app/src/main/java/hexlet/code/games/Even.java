package hexlet.code.games;

import static hexlet.code.Engine.startEngine;
import hexlet.code.GameData;

import java.util.Scanner;

public class Even {

    private static String createQuestion(int number) {
        return "Question: " + Integer.toString(number);
    }

    private static String createCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    private static GameData createGameData(String userName, String rules) {
        GameData gameData = new GameData(userName, rules);

        int number;
        for (int i = 0; i < gameData.countRound; i++) {
            number = (int) (Math.random() * 10);
            gameData.questions[i] = createQuestion(number);
            gameData.correctAnswers[i] = createCorrectAnswer(number);
        }

        return gameData;
    }

    public static void play(String userName, Scanner scanner) {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        GameData gameData = createGameData(userName, rules);
        startEngine(gameData, scanner);
    }

}
