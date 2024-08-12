package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Prime {

    public static String getCorrectAnswer(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no"; // Число делится на другое число, значит оно не простое
            }
        }
        return "yes";
    }

    public static void play(Scanner scanner) {
        String userName = Engine.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int number;
        String userAnswer;
        String correctAnswer;

        for (int round = 0; round < 3; round++) {
            number = (int) (Math.random() * 100);

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            userAnswer = scanner.next();
            correctAnswer = getCorrectAnswer(number);

            if (Engine.compareAnswers(userAnswer, correctAnswer, userName)) {
                return;
            }

            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }

}
