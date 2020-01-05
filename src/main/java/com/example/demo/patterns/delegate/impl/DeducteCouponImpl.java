package com.example.demo.patterns.delegate.impl;

import com.example.demo.patterns.delegate.Coupon;

import java.math.BigDecimal;

public class DeducteCouponImpl implements Coupon {
    @Override
    public BigDecimal couponAmount() {
        return new BigDecimal(10);
    }

    @Override
    public boolean supports() {
        return true;
    }
}
