public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        if (author == null) {
            throw new IllegalArgumentException();
        }
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
