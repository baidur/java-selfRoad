package com.example.demo.patterns.delegate.impl;

import com.example.demo.patterns.delegate.Coupon;
import com.example.demo.patterns.delegate.CouponCommon;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DeveloperCouponImpl implements Coupon {

    private static Coupon coupon = null;

    private Map<Integer,Coupon> couponMap = new HashMap<>();

    public DeveloperCouponImpl(){
        couponMap.put(CouponCommon.DEDUCTE_TYPE,new DeducteCouponImpl());
        couponMap.put(CouponCommon.FULL_TYPE,new FullCouponImpl());
    }

    public void getCoupon(Integer couponType){
        coupon = couponMap.get(couponType);
    }

    @Override
    public BigDecimal couponAmount() {
        return coupon.couponAmount();
    }

    @Override
    public boolean supports() {
        return coupon.supports();
    }
}
