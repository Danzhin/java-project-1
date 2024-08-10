package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.greeting;
import static hexlet.code.Even.isEven;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.\n1 - Greet\n2 - Even\n0 - Exit");
        System.out.print("Your choice: ");
        String number = scanner.next();
        System.out.println();

        int action = Integer.parseInt(number);

        switch (action) {
            case 0:
                break;
            case 1:
                greeting(scanner);
                break;
            case 2:
                isEven(scanner);
                break;
        }

        scanner.close();
    }
}
