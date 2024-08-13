package hexlet.code.games;

import hexlet.code.Game;
import java.util.Scanner;

public class Calc extends Game {

    public int number1;
    public int number2;
    public int indexOperation = 0;
    public final String[] operations = {"+", "-", "*"};

    public Calc(Scanner scanner) {
        super(scanner);
        rules = "What is the result of the expression?";
    }

    public void askQuestion() {
        number1 = (int) (Math.random() * 10);
        number2 = (int) (Math.random() * 10);
        System.out.println("Question: " + number1 + " " + operations[indexOperation] + " " + number2);
    }

    public void getCorrectAnswer() {
        int result = switch (indexOperation++) {
            case 0 -> number1 + number2;
            case 1 -> number1 - number2;
            case 2 -> number1 * number2;
            default -> 0;
        };
        correctAnswer = Integer.toString(result);
    }

}
