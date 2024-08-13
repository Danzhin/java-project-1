package hexlet.code;

import java.util.Scanner;

public abstract class Game {

    public final int countRound = 3;
    public String rules;
    public String userName;
    public String userAnswer;
    public String correctAnswer;
    public Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    public void printRules(String rules) {
        System.out.println(rules);
    }

    public void getAnswer() {
        System.out.print("Your answer: ");
        userAnswer = scanner.next();
    }

    public boolean compareAnswers() {
        return userAnswer.equals(correctAnswer);
    }

    public abstract void askQuestion();

    public abstract void getCorrectAnswer();

    public void play() {
        greeting();
        printRules(rules);
        for (int i = 0; i < countRound; i++) {
            askQuestion();
            getAnswer();
            getCorrectAnswer();
            if(!compareAnswers()) {
                System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }

}

