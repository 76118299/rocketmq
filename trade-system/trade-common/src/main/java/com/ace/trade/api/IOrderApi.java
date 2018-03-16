package com.ace.trade.api;

import com.ace.trade.protocl.order.ConfirmOrderReq;
import com.ace.trade.protocl.order.ConfirmOrderRes;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public interface IOrderApi {
    public ConfirmOrderRes confirmOrder(ConfirmOrderReq req);
}
