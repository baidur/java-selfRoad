package com.example.demo.patterns.adapter;

public class ChinaPowerAdapter implements DC5Adapter {

    @Override
    public boolean support(AC ac) {
        return ac instanceof AC220 ;
    }

    @Override
    public int outPutDC5V(AC ac) {
        int adapterInput = ac.outPutAC();
        //变压器...
        int adapterOutput = adapterInput / 44;
        System.out.println("使用ChinaPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
