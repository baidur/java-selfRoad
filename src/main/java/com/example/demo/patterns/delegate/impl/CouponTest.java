package com.example.demo.patterns.delegate.impl;

import com.example.demo.patterns.delegate.CouponCommon;

/**
 * 委派模式（Delegate）是面向对象设计模式中常用的一种模式。这种模式的原理为类B和类A是两个互相没有任何关系的类，B具有和A一模一样的方法和属性；并且调用B中的方法，属性就是调用A中同名的方法和属性。B好像就是一个受A授权委托的中介。第三方的代码不需要知道A的存在，也不需要和A发生直接的联系，通过B就可以直接使用A的功能，这样既能够使用到A的各种公能，又能够很好的将A保护起来了。
 * ————————————————
 * 版权声明：本文为CSDN博主「G2AL」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/u012240777/article/details/80214476
 */
public class CouponTest {

    public static void main(String[] args) {
        DeveloperCouponImpl developerCoupon = new DeveloperCouponImpl();
        developerCoupon.getCoupon(CouponCommon.FULL_TYPE);
        System.out.println(developerCoupon.couponAmount());
        System.out.println(developerCoupon.supports());
    }

}
