package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;


public class ProductManager {

    private Repository repo = new Repository();

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;

                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.matches(search);
    }

    public Product[] findAll() {
        return repo.findAll();
    }

    public void removeId(int removeId) {
        repo.removeId(removeId);
    }
}