package hexlet.code.games;

import hexlet.code.Game;
import java.util.Scanner;

public class Progression extends Game {

    private int[]  progression = new int[5];
    private int indexMissedNumber = 0;

    public Progression(Scanner scanner) {
        super(scanner);
        rules = "What number is missing in the progression?";
    }

    protected void askQuestion() {
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

    protected void getCorrectAnswer() {
        correctAnswer = Integer.toString(progression[indexMissedNumber]);
        indexMissedNumber += 2;
    }

}
