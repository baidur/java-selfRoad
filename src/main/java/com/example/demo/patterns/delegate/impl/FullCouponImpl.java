package com.example.demo.patterns.delegate.impl;

import com.example.demo.patterns.delegate.Coupon;

import java.math.BigDecimal;

public class FullCouponImpl implements Coupon {

    @Override
    public BigDecimal couponAmount() {
        return new BigDecimal(15);
    }

    @Override
    public boolean supports() {
        return false;
    }
}
