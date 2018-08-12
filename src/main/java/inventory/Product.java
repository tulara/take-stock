package inventory;

public class Product {
    private int productId;
    private String author;
    private String title;
    private int inStock;

    public Product(int productId, String author, String title, int inStock) {
        this.productId = productId;
        this.author = author;
        this.title = title;
        this.inStock = inStock;
    }

    public int getInStock() {
        return inStock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getProductId() {
        return productId;
    }
}
