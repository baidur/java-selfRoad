package com.example.demo.patterns.adapter;

import java.util.*;

/**
 * 适配器模式（Adapter Pattern）的定义如下：
 * Convert the interface of a class into another interface clients expect.Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
 * 将一个类的接口变换成客户 端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 * 角色：Target目标角色；Adaptee源角色；Adapter适配器角色
 * 两种实现方式：类适配器模式（继承），对象适配器模式（关联）
 * 运用场景：适配器应用的场景只要记住一点就足够了：你有动机修改一个已经投产中的接口时，适配器模式可能是最适合你的模式。
 * 比如系统扩展了，需要使用一个已有或新建立的类，但这 个类又不符合系统的接口，怎么办？使用适配器模式，这也是我们例子中提到的。
 * 优缺点：
 * ● 适配器模式可以让两个没有任何关系的类在一起运行，只要适配器这个角色能够搞定 他们就成。
 * ● 增加了类的透明性 想想看，我们访问的Target目标角色，但是具体的实现都委托给了源角色，而这些对高 层次模块是透明的，也是它不需要关心的。
 * ● 提高了类的复用度 当然了，源角色在原有的系统中还是可以正常使用，而在目标角色中也可以充当新的演 员。
 * ● 灵活性非常好 某一天，突然不想要适配器，没问题，删除掉这个适配器就可以了，其他的代码都不用 修改，基本上就类似一个灵活的构件，想用就用，不想就卸载。
 */
public class Test {

    private List<DC5Adapter> adapters = new ArrayList<>(2);
    public Test(){
        adapters.add(new JapanPowerAdapter());
        adapters.add(new ChinaPowerAdapter());
    }

    // 根据电压找合适的变压器
    public DC5Adapter getPowerAdapter(AC ac) {
        DC5Adapter adapter = null ;
        for(DC5Adapter ad : adapters){
            if(ad.support(ac)){
                adapter = ad;
                break;
            }
        }
        if (null == adapter){
            throw new IllegalArgumentException("没有找到合适的变压适配器");
        }
        return adapter;
    }

    public static void main(String[] args) {
        Test test = new Test();
        AC chinaAC = new AC220();
        DC5Adapter adapter = test.getPowerAdapter(chinaAC);
        adapter.outPutDC5V(chinaAC);

        // 去日本旅游，电压是 110V
        AC japanAC = new AC110();
        adapter = test.getPowerAdapter(japanAC);
        adapter.outPutDC5V(japanAC);
    }
}
