package com.ace.trde.service.serviceImpl;

import com.ace.trade.protocl.pay.CallbackPayMentReq;
import com.ace.trade.protocl.pay.CallbackPayMentRes;
import com.ace.trade.protocl.pay.CreatePayMentReq;
import com.ace.trade.protocl.pay.CreatePayMentRes;
import com.ace.trade.rocketmq.AceTradeMQProducer;
import com.ace.trde.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/3/16 0016.
 */
@Service
public class PayServiceImpl implements IPayService {
    @Autowired
    private AceTradeMQProducer producer;

    /**
     * 创建支付订单表 （插入数据）
     * @param req
     * @return
     */
    public CreatePayMentRes createPayMent(CreatePayMentReq req) {
        return null;
    }

    /**
     * 支付回调方法
     * @param req
     * @return
     */
    @Transactional
    public CallbackPayMentRes CallbackPayMent(CallbackPayMentReq req) {
        //先根据支付订单主键ID查询该订单是否支付
        //没有找到 null 或者该订单已支付就 都抛出异常
        //更新支付订单 的状态为已支付

        //如果更新成功
        //就发送mq消息给订单系统
        //发送消息前 要把消息插入消息表中
        //然后用线程池发送消息给订单系统
        return null;
    }
}
