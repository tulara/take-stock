import repositories.PostgresConnector;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new PostgresConnector().connect();

        System.out.println("enter a thing: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(input);

    }
}
