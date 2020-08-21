package com.example.demo.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkBlogProxyFactory {

    private Object target;

    public JdkBlogProxyFactory(Object target) {
        this.target = target;
    }

    public Object newInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new handler());
    }

    private class handler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("开锁");
            //执行被代理对象的method方法
            Object o = method.invoke(target,args);
            System.out.println("加速");
            return o;
        }
    }
}
