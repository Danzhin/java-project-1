package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.*;

public class Even {

    public static void play(Scanner scanner) {
        String userName = greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int randomNumber;
        String userAnswer;
        String correctAnswer;
        for (int round = 0; round < 3; round++) {
            randomNumber = (int) (Math.random() * 100);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            userAnswer = scanner.next();
            correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
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
