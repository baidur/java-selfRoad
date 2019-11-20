package com.example.demo.reflect.test;

import com.example.demo.reflect.entity.User;
import com.example.demo.reflect.util.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 元注解
 *
 * 元注解用于注解其他注解的。Java 5.0定义了4个标准的元注解，如下：
 *
 * @Target
 * @Retention
 * @Documented
 * Inherited
 * 现在来说说这四个元注解有什么作用。
 *
 * @Target
 *
 * 　@Target注解用于声明注解的作用范围，例如作用范围为类、接口、方法等。它的取值以及值所对应的范围如下：
 *
 * CONSTRUCTOR:用于描述构造器
 * FIELD:用于描述域
 * LOCAL_VARIABLE:用于描述局部变量
 * METHOD:用于描述方法
 * PACKAGE:用于描述包
 * PARAMETER:用于描述参数
 * TYPE:用于描述类、接口(包括注解类型) 或enum声明
 * @Retention
 *
 * 该注解声明了注解的生命周期，即注解在什么范围内有效。
 *
 * SOURCE:在源文件中有效
 * CLASS:在class文件中有效
 * RUNTIME:在运行时有效（即运行时保留）
 * 大多数注解都为RUNTIME
 *
 * @Documented
 *
 * 是一个标记注解，有该注解的注解会在生成 java 文档中保留。
 *
 * @Inherited
 *
 * 该注解表明子类是有继承了父类的注解。比如一个注解被该元注解修饰，并且该注解的作用在父类上，那么子类有持有该注解。
 * 如果注解没有被该元注解修饰，则子类不持有父类的注解。
 * 在注解中，需要使用四种元注解来声明注解的作用范围、生命周期、继承，是否生成文档等。
 * 另外在注解中也可以有自己的成员变量，如果一个注解没有成员变量则称为标记注解。
 * 注解的成员变量，只支持原始类型、Class、Enumeration、Annoation。
 */
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user = new User(10,"chen","杭州");
        AnnotationUtils.getSql(user);
    }
}
