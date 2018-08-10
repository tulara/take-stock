import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("enter a thing: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        System.out.println(input);

    }
}
