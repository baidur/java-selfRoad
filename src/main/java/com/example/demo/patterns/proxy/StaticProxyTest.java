package com.example.demo.patterns.proxy;

/**
 * 静态代理
 * 在代理模式中有三个角色，一是目标接口，二是目标对象，三是代理对象
 * 优点：
 * ● 职责清晰 真实的角色就是实现实际的业务逻辑，不用关心其他非本职责的事务，通过后期的代理 完成一件事务，附带的结果就是编程简洁清晰。
 * ● 高扩展性 具体主题角色是随时都会发生变化的，只要它实现了接口，甭管它如何变化，都逃不脱 如来佛的手掌（接口），那我们的代理类完全就可以在不做任何修改的情况下使用。
 * ● 智能化 这在我们以上的讲解中还没有体现出来，不过在我们以下的动态代理章节中你就会看到 代理的智能化有兴趣的读者也可以看看Struts是如何把表单元素映射到对象上的。
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        CarService carService = new CarServiceImpl() ;
        CarProxy carProxy = new CarProxy(carService);
        carProxy.start();
    }
}
