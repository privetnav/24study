package ru.inno.controllers;

import java.util.Random;

public class BaseService {

    private int value;

    public int getValue() {
        if(value == 0) {
            Random random = new Random();
            value = random.nextInt();
        }
        return value;
    }
}
