package com.petro.model.entity;

import com.petro.model.InvokeMe;

/**
 * Created by Администратор on 22.05.2017.
 */
public interface ScheduleItemInterface extends TimeInterface{
    @InvokeMe
    String getDiscipline();

    void setDiscipline(String discipline);

    @InvokeMe
    int getClassroom();

    void setClassroom(int classroom);

    ScheduleItemInterface clone();
}
