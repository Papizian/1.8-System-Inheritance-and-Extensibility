import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new ProductRepository();
    }

    @Test
    public void shouldRemoveExistingProduct() {
        Book book = new Book(1, "Python book", 100, "King");
        repository.save(book);

        repository.removeById(1);

        assertEquals(0, repository.findAll().length);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenRemovingNonExistingProduct() {
        Book book = new Book(1, "Python book", 100, "King");
        repository.save(book);

        assertThrows(NotFoundException.class, () -> repository.removeById(2));
    }
}
