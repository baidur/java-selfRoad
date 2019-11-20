package com.example.demo.reflect.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 */
public class ClassUtils {

    /**
     * 获取类的所有方法
     */
    public static void getMethods(Object o){
        Class c = o.getClass();
        System.out.println("类的名称："+c.getName());
        /**
         * 一个成员方法就是一个method对象
         * getMethod()所有的 public方法，包括父类继承的 public
         * getDeclaredMethods()获取该类所有的方法，包括private ,但不包括继承的方法。
         */
        Method[] methods = c.getMethods();
        for(Method m : methods){
            System.out.println(m.getName());
            System.out.println(m.getReturnType());
           // System.out.println(m.getParameterTypes());
        }
    }
    /**
     * 获取成员变量的信息
     */
    public static void getFields(Object o){
        Class c = o.getClass();
        /**
         * getFileds()获取public
         * getDeclaredFields()获取所有
         */
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName() +":"+ field.getType().getName() +":"+ field.hashCode());
        }
    }

    /**
     * 获取类的一个方法
     */
    public static void getMethod(Object o){
        Class c = o.getClass();
        try {
            Method method1 = c.getMethod("setAge",int.class);
            Method method2 = c.getMethod("getAge");
            method1.invoke(o,10);
            System.out.println(method2.invoke(o));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
