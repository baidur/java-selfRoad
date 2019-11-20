package com.example.demo.patterns.proxy;

/**
 * 动态代理
 * Jdk的动态代理由Proxy这个类来生成，它有三个参数：
 *
 * ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
 * Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
 * InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        CarService carService = new CarServiceImpl() ;
        CarService proxy = (CarService) new JdkBlogProxyFactory(carService).newInstance();
        proxy.start();
    }
}
