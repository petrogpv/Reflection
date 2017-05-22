package com.petro.model;

import com.petro.model.entity.ScheduleItem;
import com.petro.model.entity.ScheduleItemInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Валерий on 22.05.2017.
 */
public class ScheduleItemProxyTest {
    ScheduleItemInterface scheduleItemInterface;
    ScheduleItem scheduleItem;
    {
        scheduleItem = new ScheduleItem(15, 00, "Biology", 105);
        scheduleItemInterface = (ScheduleItemInterface)ScheduleItemProxy.newInstance(scheduleItem);
    }
    @Test
    public void testGetHour(){
        assertEquals(15 , scheduleItemInterface.getHour());
    }
    @Test
    public void testGetMinute(){
        assertEquals(00 , scheduleItemInterface.getMinute());
    }
    @Test
    public void testGetClassroom(){
        assertEquals(105 , scheduleItemInterface.getClassroom());
    }
    @Test
    public void testGetDiscipline(){
        assertEquals("Biology" , scheduleItemInterface.getDiscipline());
    }
    @Test
    public void testSetHour(){
        scheduleItemInterface.setHour(12);
        assertEquals(15, scheduleItemInterface.getHour());
    }
}