package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFound;
import ru.netology.repository.Repository;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest{
    ProductManager manager = new ProductManager();

   @Test
    void deleteId() {
       Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
       Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
       Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
       Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
       Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
       Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        manager.removeId(2);
        manager.removeId(3);
        manager.removeId(4);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, smp2, smp3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteNullId() {
        Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
        Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
        Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
        Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
        Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
        Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        assertThrows(NotFound.class, () ->{
            manager.removeId(7);
        });
    }

    @Test
    void emptyArray() {
        Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
        Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
        Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
        Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
        Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
        Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
        manager.add(book1);

        manager.removeId(1);

        Product[] actual = manager.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void allProduct() {
        Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
        Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
        Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
        Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
        Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
        Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smp1, smp2, smp3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchBName() {
        Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
        Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
        Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
        Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
        Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
        Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        Product[] actual = manager.searchBy("ing");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

   @Test
    void searchBAuthor() {
       Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
       Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
       Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
       Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
       Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
       Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
       manager.add(book1);
       manager.add(book2);
       manager.add(book3);
       manager.add(smp1);
       manager.add(smp2);
       manager.add(smp3);

        Product[] actual = manager.searchBy("Tolkien");
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmpMan() {
        Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
        Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
        Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
        Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
        Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
        Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {smp3};

        Assertions.assertArrayEquals(expected, actual);
    }

  @Test
    void searchSmpName() {
      Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
      Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
      Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
      Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
      Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
      Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        Product[] actual = manager.searchBy("one");
        Product[] expected = {smp2};

        Assertions.assertArrayEquals(expected, actual);
    }

   @Test
    void notFound() {
       Product book1 = new Book(1, "The Fellowship of The Ring", "J. R. R. Tolkien");
       Product book2 = new Book(2, "Two Towers",  "J. R. R. Tolkien");
       Product book3 = new Book(3, "The Return of the King",  "J. R. R. Tolkien");
       Product smp1 = new Smartphone(4, "Redmi Note 8",  "Xiaomi");
       Product smp2 = new Smartphone(5, "Iphone 12",  "Apple");
       Product smp3 = new Smartphone(6, "Galaxy S20", "Samsung");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smp1);
        manager.add(smp2);
        manager.add(smp3);

        Product[] actual = manager.searchBy("cucumber");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
