package com.example.testapp.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saramakm on 29-10-15.
 */
public class LoopAlgorithm1 implements Runnable {


    List<User> usersGen;

    public LoopAlgorithm1(List<User> generated) {
        usersGen = generated;
    }

    @Override
    public void run() {
        names(usersGen);
    }

    public List<String> names(List<User> users){
        List<String> names = new ArrayList<String>();
        for (String name : names) {
            names.add(name);
        }
        return names;
    }
}
