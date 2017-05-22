package com.petro.model.entity;

import com.petro.model.InvokeMe;

/**
 * Created by Администратор on 22.05.2017.
 */
public class ScheduleItem extends Time implements Cloneable, ScheduleItemInterface {
    private String discipline;
    private int classroom;

    public ScheduleItem() {
    }

    public ScheduleItem(int hour, int minute, String discipline, int classroom) {
        super(hour, minute);
        this.discipline = discipline;
        this.classroom = classroom;
    }
    public ScheduleItem(TimeInterface time, String discipline, int classroom){
        this(time.getHour(), time.getMinute(), discipline, classroom );
    }
    @Override
    @InvokeMe
    public String getDiscipline() {
        return discipline;
    }

    @Override
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    @Override
    @InvokeMe
    public int getClassroom() {
        return classroom;
    }

    @Override
    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "discipline = '" + discipline + '\'' +
                ", classroom = " + classroom +
                ", hour = " + getHour() +
                ", minute = " + getMinute() +
                '}';
    }

    @Override
    public ScheduleItem clone()  {
        try {
            return  (ScheduleItem)super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
