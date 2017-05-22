package com.petro.model;

import com.petro.model.entity.ScheduleItem;
import com.petro.model.entity.ScheduleItemInterface;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 22.05.2017.
 */
public final class Schedule {
    private List<ScheduleItemInterface> scheduleList;
    private static Schedule schedule;

    private Schedule(){
        this.scheduleList = new ArrayList<ScheduleItemInterface>();
    }

    public static Schedule getInstance(){
        if(schedule == null){
            return new Schedule();
        }
        return schedule;
    }

    public void setScheduleItem (ScheduleItemInterface item){
        scheduleList.add(item);
    }

    public List<ScheduleItemInterface> getScheduleList(){
        return cloneList(scheduleList);
    }
    private List<ScheduleItemInterface> cloneList(List<ScheduleItemInterface> list) {
        List<ScheduleItemInterface> clone = new ArrayList<ScheduleItemInterface>(list.size());
        for (ScheduleItemInterface item : list)
                clone.add((ScheduleItem)item.clone());
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        scheduleList.stream().forEach(x -> sb.append(x).append("\n"));
        return sb.toString();
    }
}
