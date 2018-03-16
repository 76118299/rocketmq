package com.ace.trade.protocl.order;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class ConfirmOrderReq {
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getMoneyPaId() {
        return moneyPaId;
    }

    public void setMoneyPaId(BigDecimal moneyPaId) {
        this.moneyPaId = moneyPaId;
    }

    private Integer userId;
    private String address;
    private Integer goodsId;
    private Integer goodsNum;
    private Integer couponId;
    private BigDecimal moneyPaId;

    public BigDecimal getShippingFree() {
        return shippingFree;
    }

    public void setShippingFree(BigDecimal shippingFree) {
        this.shippingFree = shippingFree;
    }

    private BigDecimal shippingFree;
    public BigDecimal getGoodesPrice() {
        return goodesPrice;
    }

    public void setGoodesPrice(BigDecimal goodesPrice) {
        this.goodesPrice = goodesPrice;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    private BigDecimal goodesPrice;
    private BigDecimal orderAmount;
}
