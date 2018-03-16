package com.ace.trade.protocl.pay;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/3/16 0016.
 */
public class CreatePayMentReq {
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    private String orderId;
    private BigDecimal payAmount;

}
