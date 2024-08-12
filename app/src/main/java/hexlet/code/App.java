package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.greeting;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int action = Integer.parseInt(scanner.next());
        System.out.println();

        switch (action) {
            case 1:
                String name = greeting(scanner);
                break;
            case 2:
                Even.play(scanner);
                break;
            case 3:
                Calc.play(scanner);
                break;
            case 4:
                Gcd.play(scanner);
                break;
            case 5:
                Progression.play(scanner);
                break;
            case 6:
                Prime.play(scanner);
                break;
            default:
                break;
        }
        scanner.close();
    }
}
