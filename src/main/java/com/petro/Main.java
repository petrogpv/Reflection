package com.petro;

import com.petro.model.Schedule;
import com.petro.view.View;

/**
 * Created by Администратор on 22.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Schedule schedule = Schedule.getInstance();
        View view = new View();
        new Controller(schedule, view).proces();
    }
}
