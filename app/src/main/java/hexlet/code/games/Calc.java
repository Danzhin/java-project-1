package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.*;
import static hexlet.code.games.Even.play;

public class Calc {

    public static void play(Scanner scanner) {
        String userName = greeting(scanner);
        System.out.println("What is the result of the expression?");

        int number1; int number2;
        int userAnswer;
        int correctAnswer;
        final String[] operations = {"+", "-", "*"};
        for (int round = 0; round < 3; round++) {
            number1 = (int) (Math.random() * 10) + 1;
            number2 = (int) (Math.random() * 10) + 1;
            correctAnswer = switch (operations[round]) {
                case "+" -> {
                    System.out.println("Question: " + number1 + "+" + number2);
                    yield number1 + number2;
                }
                case "-" -> {
                    System.out.println("Question: " + number1 + "-" + number2);
                    yield number1 - number2;
                }
                default -> {
                    System.out.println("Question: " + number1 + "*" + number2);
                    yield number1 * number2;
                }
            };
            System.out.print("Your answer: ");
            userAnswer = Integer.parseInt(scanner.next());
            if (!compareAnswers(userAnswer, correctAnswer)) {
                errorMessage(userAnswer, correctAnswer);
                printLossMessage(userName);
                return;
            }
            System.out.println("Correct!");
        }
        printVictoryMessage(userName);
    }
}
