package com.example.demo.reflect.util;

import com.example.demo.reflect.annotation.Column;
import com.example.demo.reflect.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationUtils {

    public static void getSql(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = o.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ");
        if(c.isAnnotationPresent(Table.class)){
            Table table = (Table) c.getAnnotation(Table.class);
            String tableName = table.value();
            stringBuilder.append(tableName).append(" where 1=1");
        }
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            String columnName;
            if(field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                columnName = column.value();
            }else {
                continue;
            }
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = c.getMethod(getMethodName);
            Object fieldValue = method.invoke(o);
            if (fieldValue == null || ((fieldValue instanceof Integer) && (Integer) fieldValue == 0)) {
                continue;
            }
            if (fieldValue instanceof Integer) {
                stringBuilder.append(" and ").append(columnName).append("=").append(fieldValue);
            }
            if (fieldValue instanceof String) {
                stringBuilder.append(" and ").append(columnName).append("=").append("'").append(fieldValue).append("'");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
