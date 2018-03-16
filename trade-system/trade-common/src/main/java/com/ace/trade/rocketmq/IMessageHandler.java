package com.ace.trade.rocketmq;

import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public interface IMessageHandler {
    public boolean messageHandler(MessageExt messageExt);


}
