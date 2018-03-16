package com.ace.trde.api;

import com.ace.trade.api.IPayApi;
import com.ace.trade.protocl.pay.CallbackPayMentReq;
import com.ace.trade.protocl.pay.CallbackPayMentRes;
import com.ace.trade.protocl.pay.CreatePayMentReq;
import com.ace.trade.protocl.pay.CreatePayMentRes;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2018/3/16 0016.
 */
@Controller
public class PayApi implements IPayApi {
    public CreatePayMentRes createPayMent(CreatePayMentReq req) {
        return null;
    }

    public CallbackPayMentRes CallbackPayMent(CallbackPayMentReq req) {
        return null;
    }
}
