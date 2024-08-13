package hexlet.code.games;

import hexlet.code.Game;
import java.util.Scanner;

public class Prime extends Game {

    private int number;

    public Prime(Scanner scanner) {
        super(scanner);
        rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    protected void askQuestion() {
        number = (int) (Math.random() * 100);
        System.out.println("Question: " + number);
    }

    protected void getCorrectAnswer() {
        correctAnswer = "yes";
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                correctAnswer = "no";
                break;
            }
        }
    }
}
