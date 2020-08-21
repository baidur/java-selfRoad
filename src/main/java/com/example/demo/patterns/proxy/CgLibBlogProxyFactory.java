package com.example.demo.patterns.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibBlogProxyFactory {

    private Object target;

    public CgLibBlogProxyFactory(Object target) {
        this.target = target;
    }

    public Object newInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new handler());
        return enhancer.create();
    }

    private class handler implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("开锁");
            //执行被代理对象的method方法
            methodProxy.invokeSuper(o,objects);
            System.out.println("加速");
            return o;
        }
    }
}
