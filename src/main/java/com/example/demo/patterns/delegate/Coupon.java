package com.example.demo.patterns.delegate;

import java.math.BigDecimal;

public interface Coupon {

    /**
     * 优惠多少钱
     * @return
     */
    BigDecimal couponAmount();

    /**
     * 是否支持
     * @return
     */
    boolean supports();
}
