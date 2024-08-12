package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Progression {

    public static void createProgression(int[] progression) {
        int number = (int) (Math.random() * 10) + 1;
        int step = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < progression.length; i++) {
            number += step;
            progression[i] = number;
        }
    }

    public static void printQuestion(int[] progression, int missedNumber) {
        System.out.print("Question: ");
        for (int number : progression) {
            if (number == missedNumber) {
                System.out.print(".. ");
            } else {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    public static void play(Scanner scanner) {
        String userName = Engine.greeting(scanner);
        System.out.println("What number is missing in the progression?");

        int[]  progression = new int[10];
        int userAnswer;
        int correctAnswer;
        int index = 2;
        for (int round = 0; round < 3; round++) {
            createProgression(progression);

            correctAnswer = progression[index];

            printQuestion(progression, correctAnswer);
            System.out.print("Your answer: ");

            userAnswer = Integer.parseInt(scanner.next());

            if (Engine.compareAnswers(userAnswer, correctAnswer, userName)) {
                return;
            }

            System.out.println("Correct!");

            index += 2;
        }
        System.out.println("Congratulations, " + userName + "!");
    }

}
