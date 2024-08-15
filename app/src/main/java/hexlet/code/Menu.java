package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.HashMap;
import java.util.Map;
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

    private static Map<String, Runnable> getStringRunnableMap(Scanner scanner) {
        final int countRounds = 3;

        Map<String, Runnable> actions = new HashMap<>();
        actions.put("2", () -> Even.play(greeting(scanner), scanner, countRounds));
        actions.put("3", () -> Calc.play(greeting(scanner), scanner, countRounds));
        actions.put("4", () -> GCD.play(greeting(scanner), scanner, countRounds));
        actions.put("5", () -> Progression.play(greeting(scanner), scanner, countRounds));
        actions.put("6", () -> Prime.play(greeting(scanner), scanner, countRounds));
        return actions;
    }

    public static void selectAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your choice: ");
        String action = scanner.next();
        System.out.println();

        Map<String, Runnable> actions = getStringRunnableMap(scanner);

        if (!action.equals("0")) {
            Runnable selectedAction = actions.get(action);
            if (selectedAction != null) {
                selectedAction.run();
            } else {
                System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        printMenu();
        selectAction();
    }
}