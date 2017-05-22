package com.petro.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Администратор on 22.05.2017.
 */
public class ScheduleItemProxy implements InvocationHandler {
    private Object obj;

    public static Object newInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new ScheduleItemProxy(obj));
    }

    private ScheduleItemProxy(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ScheduleItemProxy invoke : " + method.getName());
        if (method.getName().startsWith("set")) {
            try {
                throw new AccessDeniedException("You can not change object " + obj.getClass().getSimpleName());
            } catch (AccessDeniedException e) {
                e.printStackTrace();
            }
            return null;
        }

        return method.invoke(obj, args);
    }
}
