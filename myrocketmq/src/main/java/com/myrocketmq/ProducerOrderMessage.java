package com.myrocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 发送顺序消息
 * Created by Administrator on 2018/3/10 0010.
 */
public class ProducerOrderMessage {
    public static void  main(String[] args){
        DefaultMQProducer producer = new DefaultMQProducer("order_producer");
        producer.setNamesrvAddr("192.168.1.1:9876;192.168.1.2:9876");
        try {
            producer.start();

            Date date = new Date();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dateFormat = format.format(date);
            //一次发送5次消息 要求消息严格有序
            for(int i=0;i<5;i++){
                String body = dateFormat+"orderMessge"+i;
                Message message = new Message("OrderMessageTopic","TagA","orderKey"+i,body.getBytes());
                //发送消息指定消息的队列 这样就是一个顺序消息了 实现MessageQueueSelector类就是返回一个队列
                /**
                 * message:消息
                 * MessageQueueSelector ：回调接口
                 * Object :就是队列的下标
                 */
                producer.send(message, new MessageQueueSelector() {
                    /**
                     *
                     * @param msgs  集合里面放的是队列
                     * @param message 我们的消息
                     * @param arg  队列的下标 就是把消息放到  那个队列中
                     * @return
                     */
                    @Override
                    public MessageQueue select(List<MessageQueue> msgs, Message message, Object arg) {
                        Integer id = (Integer) arg;
                        return msgs.get(id);
                    }
                },1); //队列下标  如果发送多个队列 就改变下标值就行啦

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
