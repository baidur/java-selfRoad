package com.example.demo.patterns.proxy;

import java.lang.reflect.Proxy;

public class JdkBlogProxyFactory {

    private Object target;

    public JdkBlogProxyFactory(Object target) {
        this.target = target;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("开锁");
                    Object o = method.invoke(target, args);
                    System.out.println("加速");
                    return o;
                });
    }
}
