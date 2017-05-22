package com.petro;

import com.petro.model.InvokeMe;
import com.petro.model.Schedule;
import com.petro.model.ScheduleItemProxy;
import com.petro.model.entity.*;
import com.petro.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Администратор on 22.05.2017.
 */
public class Controller {
    Schedule schedule;
    View view;

    public Controller(Schedule schedule, View view) {
        this.schedule = schedule;
        this.view = view;
    }

    public void proces() {
        // 1. using of constructors
        fillScheduleUsingConstructors();

        // 2. invoke annotated methods
        invokeAnnotatedMethods();

        // 3. Explore class
        exploreClass();

        // 4.Access trough proxy (only read)
        onlyRead();
    }


    public void fillScheduleUsingConstructors() {
        view.printMessage("\t1. Using constructors result: ");
        TimeInterface time1 = new Time(12, 00);
        TimeInterface time2 = new Time(14, 00);
        TimeInterface time3 = new Time(16, 00);
        ScheduleItemInterface scheduleItem1 = new ScheduleItem(time1, "Mathematics", 102);
        ScheduleItemInterface scheduleItem2 = new ScheduleItem(time2, "Biology", 102);
        ScheduleItemInterface scheduleItem3 = new ScheduleItem(time3, "Physics", 102);

        schedule.setScheduleItem(scheduleItem1);
        schedule.setScheduleItem(scheduleItem2);
        schedule.setScheduleItem(scheduleItem3);

        view.printMessage(schedule.toString());
    }

    public void invokeAnnotatedMethods() {
        ScheduleItemInterface scheduleItem = schedule.getScheduleList().get(0);
        Class clazz = scheduleItem.getClass();

        Method[] methods = clazz.getMethods();

        Object object = null;

        view.printMessage("\t2. Invocation of methods annotated with @InvokeMe annotation: ");
        for (Method method : methods) {
            if (method.isAnnotationPresent(InvokeMe.class)) {
                try {
                    object = method.invoke(scheduleItem);
                    if (method.getReturnType().equals(String.class)) {
                        view.printMessage((String) object);
                    }
                    if (method.getReturnType().equals(int.class)) {
                        view.printMessage(String.valueOf((Integer) object));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private void exploreClass() {
        view.printMessage("\t3. Getting class name of object through reflection: ");

        Class clazz = null;
        try {
            clazz = Class.forName("com.petro.model.entity.ScheduleItem");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        view.printMessage(clazz.getName());

        view.printMessage("\n\t3.1. Getting list of methods with name, annotations and parameters types:");

//        Method [] allMethods = clazz.getDeclaredMethods();
        Method[] allMethods = clazz.getMethods();
        StringBuilder resultString = new StringBuilder();

        for (Method m : allMethods) {
            fillResultString(m, resultString);
        }
        view.printMessage(resultString.toString());

        view.printMessage("\n\t3.3. Getting package name and class short name:");
        view.printMessage(clazz.getPackage().getName());
        view.printMessage(clazz.getSimpleName());

    }

    private void fillResultString(Method m, StringBuilder resultString) {
        resultString.append("Method: ")
                .append(m.getName());

        resultString.append(", \tAnnotations: ");

        Annotation[] annotations = m.getDeclaredAnnotations();
        if (annotations.length != 0) {
            for (Annotation a : annotations) {
                resultString.append(a.annotationType().getName())
                        .append(", ");
            }
        } else {
            resultString.append("absent");
        }

        resultString.append(", \tParameters type: ");

        Class<?>[] types = m.getParameterTypes();
        if (types.length != 0) {
            for (int i = 0; i < types.length; i++) {
                resultString.append(types[i].getName()).append(", ");
            }
        } else {
            resultString.append("absent");
        }
        resultString.append("\n");
    }
    private void onlyRead() {
        view.printMessage("\t4. Only read proxy: ");
        ScheduleItemInterface scheduleItem = schedule.getScheduleList().get(0);
        ScheduleItemInterface proxy = (ScheduleItemInterface) ScheduleItemProxy.newInstance(scheduleItem);

        view.printMessage("Get hour: ");
        System.out.println(proxy.getHour());
        view.printMessage("Set hour 20: ");
        proxy.setHour(20);

    }
}
