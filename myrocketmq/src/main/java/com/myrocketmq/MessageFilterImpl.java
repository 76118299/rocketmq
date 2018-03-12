package com.myrocketmq;

import com.alibaba.rocketmq.common.filter.MessageFilter;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 高级消息过滤器
 * Created by Administrator on 2018/3/11 0011.
 */
public class MessageFilterImpl implements MessageFilter {
    @Override
    public boolean match(MessageExt messageExt) {
        String criteria = messageExt.getUserProperty("criteria");
        //根据条件过滤该消息
        Integer id = Integer.parseInt(criteria);
        //如果ID==1说明是符合条件的消息
        if(id==1){
            return true;
        }

        return false;
    }
}
