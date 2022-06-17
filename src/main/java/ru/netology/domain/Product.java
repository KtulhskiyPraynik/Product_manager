package ru.netology.domain;

import lombok.Data;

@Data
public class Product {
    protected int id;
    protected String name;

    public boolean matches(String search) {
        return this.getName().contains(search);
    }
}
