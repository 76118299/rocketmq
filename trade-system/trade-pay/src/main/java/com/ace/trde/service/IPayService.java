package com.ace.trde.service;

import com.ace.trade.protocl.pay.CallbackPayMentReq;
import com.ace.trade.protocl.pay.CallbackPayMentRes;
import com.ace.trade.protocl.pay.CreatePayMentReq;
import com.ace.trade.protocl.pay.CreatePayMentRes;

/**
 * Created by Administrator on 2018/3/16 0016.
 */
public interface IPayService {
    public CreatePayMentRes createPayMent(CreatePayMentReq req) ;


    public CallbackPayMentRes CallbackPayMent(CallbackPayMentReq req) ;
}
