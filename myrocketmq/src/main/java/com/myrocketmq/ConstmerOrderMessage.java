package com.myrocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10 0010.
 * 接收顺序消息
 */
public class ConstmerOrderMessage {
    public ConstmerOrderMessage(){

        try {
            DefaultMQPushConsumer orderConsumer = new DefaultMQPushConsumer("order_Consumer");
            orderConsumer.setNamesrvAddr("192.168.1.1:9876;192.168.1.2:9876");
            orderConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            orderConsumer.subscribe("OrderMessageTopic","TagA");
            orderConsumer.registerMessageListener(new Listener());
            orderConsumer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    class Listener implements MessageListenerOrderly{

        @Override
        public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
            try {
            //设置自动提交
            context.setAutoCommit(true);
            //读取顺序消息
            for(MessageExt messageExt : msgs){

                    System.out.print(""+ new String(messageExt.getBody(),"utf-8"));

            }
            } catch (Exception e) {
                e.printStackTrace();
                //
               return ConsumeOrderlyStatus.ROLLBACK;
            }
            return ConsumeOrderlyStatus.SUCCESS;
        }
    }
}
