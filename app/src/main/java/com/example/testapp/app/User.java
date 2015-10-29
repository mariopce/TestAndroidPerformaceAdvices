package com.example.testapp.app;

import java.util.Random;

/**
 * Created by saramakm on 29-10-15.
 */
public class User {
    private static Random r = new Random();
    String name;
    String surname;

    public User(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public static User generate() {
        return new User("name" + r.nextInt(), "surname");
    }
}
