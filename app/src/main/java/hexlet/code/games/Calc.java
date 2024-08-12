package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Calc {

    public static int getCorrectAnswer(int number1, int number2, String operation) {
        return switch (operation) {
            case "+" -> {
                yield number1 + number2;
            }
            case "-" -> {
                yield number1 - number2;
            }
            default -> {
                yield number1 * number2;
            }
        };
    }

    public static void play(Scanner scanner) {
        String userName = Engine.greeting(scanner);
        System.out.println("What is the result of the expression?");

        int number1;
        int number2;
        int userAnswer;
        int correctAnswer;
        final String[] operations = {"+", "-", "*"};

        for (int round = 0; round < 3; round++) {
            number1 = (int) (Math.random() * 10) + 1;
            number2 = (int) (Math.random() * 10) + 1;

            System.out.println("Question: " + number1 + " " + operations[round] + " " + number2);
            System.out.print("Your answer: ");

            userAnswer = Integer.parseInt(scanner.next());
            correctAnswer = getCorrectAnswer(number1, number2, operations[round]);

            if (Engine.compareAnswers(userAnswer, correctAnswer, userName)) {
                return;
            }

            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
