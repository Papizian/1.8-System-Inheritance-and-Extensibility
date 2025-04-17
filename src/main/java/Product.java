public class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product(int id, String name, int price) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Геттеры
    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
}