package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Menu {

    public static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
    }

    public static String greeting(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static final int countRounds = 3;

    public static void selectAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your choice: ");
        String action = scanner.next();
        System.out.println();

        final int countRounds = 3;
        if (!action.equals("0")) {
            String userName = greeting(scanner);
            switch (action) {
                case "2":
                    Even.play(userName, scanner, countRounds);
                    break;
                case "3":
                    Calc.play(userName, scanner, countRounds);
                    break;
                case "4":
                    GCD.play(userName, scanner, countRounds);
                    break;
                case "5":
                    Progression.play(userName, scanner, countRounds);
                    break;
                case "6":
                    Prime.play(userName, scanner, countRounds);
                    break;
                default:
                    break;
            }
        }

        scanner.close();
    }
}
