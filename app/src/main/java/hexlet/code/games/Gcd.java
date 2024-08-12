package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;

public class Gcd {

    public static int getCorrectAnswer(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }

        return number1;
    }

    public static void play(Scanner scanner) {
        String userName = Engine.greeting(scanner);
        System.out.println("Find the greatest common divisor of given numbers.");

        int number1;
        int number2;
        int userAnswer;
        int correctAnswer;

        for (int round = 0; round < 3; round++) {
            number1 = (int) (Math.random() * 10) + 1;
            number2 = (int) (Math.random() * 10) + 1;

            System.out.println("Question: " + number1 + " " + number2);
            System.out.print("Your answer: ");

            userAnswer = Integer.parseInt(scanner.next());
            correctAnswer = getCorrectAnswer(number1, number2);

            if (Engine.compareAnswers(userAnswer, correctAnswer, userName)) {
                return;
            }

            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
