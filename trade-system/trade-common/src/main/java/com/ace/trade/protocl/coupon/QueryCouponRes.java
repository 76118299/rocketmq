package com.ace.trade.protocl.coupon;

import com.ace.trade.protocl.Base;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class QueryCouponRes extends Base {
    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    private Integer couponId;
}
