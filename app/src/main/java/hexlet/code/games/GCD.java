package hexlet.code.games;

import hexlet.code.Game;
import java.util.Scanner;

public class GCD extends Game {

    public int number1;
    public int number2;

    public GCD(Scanner scanner) {
        super(scanner);
        rules = "Find the greatest common divisor of given numbers.";
    }

    public void askQuestion() {
        number1 = (int) (Math.random() * 100);
        number2 = (int) (Math.random() * 100);
        System.out.println("Question: " + number1 + " " + number2);
    }

    public void getCorrectAnswer() {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        correctAnswer = Integer.toString(number1);
    }

}

