package hexlet.code.games;

import hexlet.code.Game;
import java.util.Scanner;

public class Even extends Game {

    private int number;

    public Even(Scanner scanner) {
        super(scanner);
        rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public void askQuestion() {
        number = (int) (Math.random() * 100);
        System.out.println("Question: " + number);
    }

    public void getCorrectAnswer() {
        correctAnswer = number % 2 == 0 ? "yes" : "no";
    }

}
