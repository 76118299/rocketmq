package com.ace.trade.protocl.pay;

/**
 * Created by Administrator on 2018/3/16 0016.
 */
public class CallbackPayMentReq {
    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    private String payId;
    private boolean isPay;
}
