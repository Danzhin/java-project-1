package hexlet.code.games;

import hexlet.code.Game;
import java.util.Scanner;

public class Progression extends Game {

    public int[]  progression = new int[5];
    public int indexMissedNumber = 0;

    public Progression(Scanner scanner) {
        super(scanner);
        rules = "What number is missing in the progression?";
    }

    public void askQuestion() {
        int number = (int) (Math.random() * 10) + 1;
        int step = (int) (Math.random() * 9) + 1;
        System.out.print("Question: ");
        for (int i = 0; i < progression.length; i++) {
            number += step;
            progression[i] = number;
            System.out.print(i == indexMissedNumber ? ".. " : number + " ");
        }
        System.out.println();
    }

    public void getCorrectAnswer() {
        correctAnswer = Integer.toString(progression[indexMissedNumber]);
        indexMissedNumber += 2;
    }

}