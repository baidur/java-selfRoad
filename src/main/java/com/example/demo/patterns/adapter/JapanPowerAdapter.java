package com.example.demo.patterns.adapter;

public class JapanPowerAdapter implements DC5Adapter {

    @Override
    public boolean support(AC ac) {
        return ac instanceof AC110 ;
    }

    @Override
    public int outPutDC5V(AC ac) {
        int adapterInput = ac.outPutAC();
        //变压器...
        int adapterOutput = adapterInput / 22;
        System.out.println("使用JapanPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
