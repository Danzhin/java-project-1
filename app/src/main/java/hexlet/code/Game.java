package hexlet.code;

import java.util.Scanner;

public abstract class Game {

    protected final int countRound = 3;
    protected String rules;
    protected String userName;
    protected String userAnswer;
    protected String correctAnswer;
    protected Scanner scanner;

    protected Game(Scanner scanner) {
        this.scanner = scanner;
    }

    protected void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    protected void printRules() {
        System.out.println(rules);
    }

    protected void getAnswer() {
        System.out.print("Your answer: ");
        userAnswer = scanner.next();
    }

    protected boolean compareAnswers() {
        return userAnswer.equals(correctAnswer);
    }

    protected abstract void askQuestion();

    protected abstract void getCorrectAnswer();

    protected void play() {
        greeting();
        printRules();
        for (int i = 0; i < countRound; i++) {
            askQuestion();
            getAnswer();
            getCorrectAnswer();
            if (!compareAnswers()) {
                System.out.println("'" + userAnswer + "' is wrong answer. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }

}

