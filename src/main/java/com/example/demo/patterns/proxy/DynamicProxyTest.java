package com.example.demo.patterns.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Modifier;

/**
 * 动态代理:Proxy+InvocationHandler
 * Jdk的动态代理由Proxy这个类来生成，它有三个参数：
 *
 * ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
 * Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
 * InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
 */
public class DynamicProxyTest {

    public static void main(String[] args) throws IOException {
        CarService carService = new CarServiceImpl() ;
        CarService proxy = (CarService) new JdkBlogProxyFactory(carService).newInstance();
        proxy.start();

        //打印代理对象$Proxy0,为什么jdk动态代理只能代理接口，因为代理对象继承proxy，只能实现被代理对象了
        String proxyName = "com.example.demo.proxy.$Proxy0";
        Class[] interfaces = new Class[]{CarService.class};
        int accessFlags = Modifier.PUBLIC;
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyName, interfaces, accessFlags);
        // 将字节数组写出到磁盘
        File file = new File("E:$Proxy0.class");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(proxyClassFile);

    }
}
