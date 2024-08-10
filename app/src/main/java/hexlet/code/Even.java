package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void isEven(Scanner scanner) {
        Random random = new Random();
        int randomNumber;
        String name;
        String answer;
        String correctAnswer;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < 3; i++) {
            randomNumber = random.nextInt(100);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            answer = scanner.next();
            correctAnswer = (randomNumber % 2 == 0) ? ("yes") : ("no");
            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
            System.out.println("Correct!");
        }

        System.out.println("Congratulations " + name + "!");
    }
}
