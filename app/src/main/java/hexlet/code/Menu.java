package hexlet.code;

import java.util.Scanner;

import static hexlet.code.games.Even.play;

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

    public static void selectAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your choice: ");
        String action = scanner.next();
        System.out.println();

        if (!action.equals("0")) {
            String userName = greeting(scanner);
            switch (action) {
                case "1":
                    break;
                case "2":
                    play(userName, scanner);
                    break;
            }
        }

        scanner.close();
    }
}
