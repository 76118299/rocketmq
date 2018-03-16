package com.ace.trade.api;

import com.ace.trade.protocl.order.ConfirmOrderReq;
import com.ace.trade.protocl.order.ConfirmOrderRes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Controller
public class OrderApiImpl implements IOrderApi  {
    @RequestMapping
    public ConfirmOrderRes confirmOrder( @RequestBody ConfirmOrderReq req) {
        return null;
    }
}
