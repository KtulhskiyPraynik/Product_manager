package ru.netology.repository;

import ru.netology.domain.Product;

public class Repository {

    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product newProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;

        products = tmp;
    }

    public void removeId(int removeId) {
            if (findId(removeId) == null) {
                throw new NotFound("Element with id: " + removeId + " not found");
            }
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i].getId() != removeId) {
                    tmp[copyToIndex] = products[i];
                    copyToIndex++;
                }
            }

            products = tmp;
        }

    public Product findId(int searchId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == searchId) {
                return products[i];
            }
        }
        return null;
    }
}