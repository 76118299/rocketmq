package com.ace.trade.protocl.mq;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/3/14 0014.
 * 定义回滚的数据
 */
public class CancelOrderMq {
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getUserMonery() {
        return userMonery;
    }

    public void setUserMonery(BigDecimal userMonery) {
        this.userMonery = userMonery;
    }

    private String orderId;
    private String couponId;
    private String userId;
    private String goodsId;
    private Integer goodsNum;
    private BigDecimal userMonery;

}
