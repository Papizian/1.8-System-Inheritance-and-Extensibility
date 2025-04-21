import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductManager manager;
    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
        manager = new ProductManager(repository);
    }

    @Test
    public void testAddAndSearchProducts() {
        Book book1 = new Book(1, "Python for newbie", 100, "Super writer");
        Book book2 = new Book(2, "Python for pro", 200, "Test author");
        manager.add(book1);
        manager.add(book2);

        Product[] found = manager.searchBy("Python");
        assertEquals(2, found.length);
    }

    @Test
    public void testBasicMatches() {
        Book book = new Book(1, "Test Book", 500, "Author");
        assertTrue(manager.matches(book, "Test"));
        assertFalse(manager.matches(book, "Java"));
    }

    @Test
    public void testRemoveProduct() {
        Book book = new Book(1, "Book", 100, "Pupok");
        repository.save(book);
        repository.removeById(1);
        assertEquals(0, repository.findAll().length);
    }

    @Test
    public void testSearchNoResults() {
        Book book = new Book(1, "Java Book", 100, "Pupok");
        manager.add(book);
        Product[] found = manager.searchBy("Python");
        assertEquals(0, found.length);
    }

    @Test
    public void testSearchOne() {
        Book book = new Book(1, "Python book", 500, "Pupok");
        Smartphone phone = new Smartphone(2, "Smartphone", 15000, "Samsung");
        manager.add(book);
        manager.add(phone);

        Product[] found = manager.searchBy("a");
        assertEquals(1, found.length);
    }
    @Test
    public void testSearchTwo() {
        Book book = new Book(1, "Java book", 500, "Pupok");
        Smartphone phone = new Smartphone(2, "Smartphone", 15000, "Samsung");
        manager.add(book);
        manager.add(phone);

        Product[] found = manager.searchBy("a");
        assertEquals(2, found.length);
    }
    @Test
    public void testRemoveNonExistingProductShouldThrow() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        assertThrows(NotFoundException.class, () -> repo.removeById(999));
    }
}