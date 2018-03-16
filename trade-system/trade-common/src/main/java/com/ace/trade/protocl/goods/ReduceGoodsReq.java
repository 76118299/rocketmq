package com.ace.trade.protocl.goods;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class ReduceGoodsReq {
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    private Integer goodsId;
    private String goodsNumber;
    private Integer orderId;
}
