package com.example.demo.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader{

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(MyClassLoader.class.getClassLoader());
        System.out.println(MyClassLoader.class.getClassLoader().getParent());
        System.out.println(MyClassLoader.class.getClassLoader().getParent().getParent());
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> c = myClassLoader.findClass("com.example.demo.jvm.GC");
        System.out.println(c.getClassLoader());
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String url){
        File file = new File("D:/company/GC.class");
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len;
            while((len = fis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
