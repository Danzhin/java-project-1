package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.*;

public class Even {

    public static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    public static void play(Scanner scanner) {
        String userName = greeting(scanner);
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

            if (!compareAnswers(userAnswer, correctAnswer, userName)) {return;}

            System.out.println("Correct!");
        }
        printVictoryMessage(userName);
    }

}
