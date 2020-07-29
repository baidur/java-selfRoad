package com.example.demo.patterns.adapter;

public interface DC5Adapter {

    boolean support(AC ac);

    int outPutDC5V(AC ac);
}
