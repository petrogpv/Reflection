package com.petro.model.entity;

import com.petro.model.InvokeMe;

import java.util.Calendar;

/**
 * Created by Администратор on 22.05.2017.
 */
public interface TimeInterface {
    static TimeInterface getTimeToStart(TimeInterface time) {
        int currentHour, currentMinute;
        int hours, minutes;
        TimeInterface toStart = new Time();

        Calendar calendar = Calendar.getInstance();
        currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        currentMinute = calendar.get(Calendar.MINUTE);

        hours = time.getHour() - currentHour;
        if (hours < 0) {
            hours = minutes = 0;
        } else {
            minutes = time.getMinute() - currentMinute;
            if (minutes < 0) {
                if (hours == 0) {
                    minutes = 0;
                } else {
                    hours--;
                    minutes = minutes + 60;
                }
            }
        }
        time.setMinute(minutes);
        time.setHour(hours);

        return toStart;
    }

    @InvokeMe
    int getHour();

    void setHour(int hour);

    @InvokeMe
    int getMinute();

    void setMinute(int minute);

}
