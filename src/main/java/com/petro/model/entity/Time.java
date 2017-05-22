package com.petro.model.entity;

import com.petro.model.InvokeMe;
import com.petro.model.WrongTimeInputExceptiopn;

/**
 * Created by Администратор on 22.05.2017.
 */
public class Time implements Cloneable, TimeInterface {
    private int hour;
    private int minute;

    public Time() {
    }

    public Time(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }
    @Override
    @InvokeMe
    public int getHour() {
        return hour;
    }

    @Override
    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new WrongTimeInputExceptiopn("hour");
        }
        this.hour = hour;
    }
    @Override
    @InvokeMe
    public int getMinute() {
        return minute;
    }

    @Override
    public void setMinute(int minute) {
        if (minute < 0 || minute > 0) {
            throw new WrongTimeInputExceptiopn("minute");
        }
        this.minute = minute;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hour = " + hour +
                ", minute = " + minute +
                '}';
    }

    @Override
    public Time clone() throws CloneNotSupportedException {
        return (Time)super.clone();
    }
}
