import repositories.InventoryRepository;
import repositories.PostgresConnector;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InventoryRepository inventoryRepository = new InventoryRepository(new PostgresConnector());

        System.out.println("enter a name: ");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        long id = inventoryRepository.insertStock(name);

        System.out.println(String.format("saved %s into inventory with id: %d ", name, id));

    }
}
