package hexlet.code.games;

import hexlet.code.GameData;
import java.util.Scanner;

import static hexlet.code.Engine.startGame;

public class Even {

    private static String createQuestion(int number) {
        return "Question: " + number;
    }

    private static String createCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    private static GameData createGameData(int countRounds) {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[countRounds];
        String[] correctAnswers = new String[countRounds];

        int number;
        for (int i = 0; i < countRounds; i++) {
            number = (int) (Math.random() * 100 + 1);
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
