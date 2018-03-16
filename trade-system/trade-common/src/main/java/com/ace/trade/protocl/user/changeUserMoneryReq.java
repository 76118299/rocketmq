package com.ace.trade.protocl.user;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class ChangeUserMoneryReq {
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public String getMoneyLogType() {
        return moneyLogType;
    }

    public void setMoneyLogType(String moneyLogType) {
        this.moneyLogType = moneyLogType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    private Integer userId;
    private BigDecimal userMoney;
    private String moneyLogType;
    private Integer orderId;
}
