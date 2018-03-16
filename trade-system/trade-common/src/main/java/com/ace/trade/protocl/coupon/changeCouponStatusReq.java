package com.ace.trade.protocl.coupon;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class ChangeCouponStatusReq {
    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    private Integer couponId;
    private Integer orderId;
    private String isUsed;

}
