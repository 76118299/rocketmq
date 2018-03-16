package com.ace.trade.mqprocessor;

import com.ace.trade.rocketmq.IMessageHandler;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
public class CanceGoodsProcessor implements IMessageHandler {
    public boolean messageHandler(MessageExt messageExt) {
        return false;
    }
}
