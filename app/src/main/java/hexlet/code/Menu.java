package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Progression;

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

    public static void selectAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your choice: ");
        String action = scanner.next();
        System.out.println();

        Game game = switch (action) {
            case "2" -> new Even(scanner);
            case "3" -> new Calc(scanner);
            case "4" -> new GCD(scanner);
            case "5" -> new Progression(scanner);
            default -> new Prime(scanner);
        };

        game.play();
    }


}
