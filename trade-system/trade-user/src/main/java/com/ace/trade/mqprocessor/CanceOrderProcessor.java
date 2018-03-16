package com.ace.trade.mqprocessor;

import com.ace.trade.api.IUserApi;
import com.ace.trade.protocl.mq.CancelOrderMq;
import com.ace.trade.rocketmq.IMessageHandler;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 接收到了order发生异常 发来的MQ消息
 * Created by Administrator on 2018/3/15 0015.
 */
public class CanceOrderProcessor implements IMessageHandler {
    @Autowired
    private IUserApi userApi;
    public boolean messageHandler(MessageExt messageExt) {
        String  cm = new String(messageExt.getBody());
        String msgId = messageExt.getMsgId();
        String tags = messageExt.getTags();
        String topic = messageExt.getTopic();
        String keys = messageExt.getKeys();
        CancelOrderMq cmq = JSON.parseObject(cm,CancelOrderMq.class);
        //回滚用户金额 根据mq消息body的内容执行业务逻辑
        //如果是下订单异常 要还原金额
       // userApi.changeUserMonery()

        return false;
    }
}
