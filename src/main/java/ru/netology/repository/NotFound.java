package ru.netology.repository;

public class NotFound extends RuntimeException {
    public NotFound(String msg){
        super(msg);
    }
}
