import inventory.InventoryRepository;
import database.PostgresConnector;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InventoryRepository inventoryRepository = new InventoryRepository(new PostgresConnector());
        System.out.println("So, you want to save a book.");
        System.out.println("Enter a title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        System.out.println("Enter an author: ");
        String author = scanner.nextLine();

        System.out.println("Enter the isbn: ");
        String isbn = scanner.nextLine();

        long id = inventoryRepository.insertStock(title, author, isbn);

        if(id == -1){
            System.out.println(String.format("failed to save inventory"));
        } else {
            System.out.println(String.format("saved '%s' into inventory with product id: %d ", title, id));
        }

    }
}
