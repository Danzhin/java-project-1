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

    private static String getUserName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void selectAction() {
        Scanner scanner = new Scanner(System.in);

        Map<String, Runnable> gameMap = new HashMap<>();

        gameMap.put("1", () -> getUserName(scanner));
        gameMap.put("2", () -> Even.play(getUserName(scanner), scanner));
        gameMap.put("3", () -> Calc.play(getUserName(scanner), scanner));
        gameMap.put("4", () -> GCD.play(getUserName(scanner), scanner));
        gameMap.put("5", () -> Progression.play(getUserName(scanner), scanner));
        gameMap.put("6", () -> Prime.play(getUserName(scanner), scanner));
        gameMap.put("default", () -> { });

        System.out.print("Your choice: ");
        String action = scanner.next();
        System.out.println();

        gameMap.getOrDefault(action, gameMap.get("default")).run();

        scanner.close();
    }

}

