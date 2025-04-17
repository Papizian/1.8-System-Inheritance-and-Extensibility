public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        int count = 0;
        for (Product product : products) {
            if (product.getId() == id) {
                count++;
            }
        }

        if (count == 0) {
            return;
        }

        Product[] tmp = new Product[products.length - count];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index++] = product;
            }
        }
        products = tmp;
    }
}