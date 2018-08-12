package api;

import database.PostgresConnector;
import inventory.InventoryRepository;
import inventory.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductController {

    @RequestMapping(value = "/product/{productid}", method=GET)
    public Product product(@PathVariable("productid") int productId) {
        InventoryRepository inventoryRepository = new InventoryRepository(new PostgresConnector());
        return inventoryRepository.getProduct(productId);
    }
}
