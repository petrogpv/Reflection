package com.petro.model;

/**
 * Created by Администратор on 22.05.2017.
 */
public class WrongTimeInputExceptiopn extends IllegalArgumentException {
    public WrongTimeInputExceptiopn(String message) {
        super("Wrong " + message + " input!");
    }
}
