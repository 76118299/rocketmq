package com.myrocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Created by Administrator on 2018/3/10 0010.
 * rocketmq 消息发送者 producer
 */
public class Producer {
    public static  void main(String[] args){
        //创建默认的消息发送者 并起组名
        DefaultMQProducer  producer = new DefaultMQProducer("mymqgroup");
        //绑定nameserver的地址和端口
        producer.setNamesrvAddr("192.168.1.1:9876;192.168.1.2:9876");
        //发送消息的时候自动创建服务器不存在的topic
        //producer.createTopic();
        //消息发送的超时
        //producer.getSendMsgTimeout();
        //发送消息的时候自动创建topic 默认创建队列数量
        //producer.getDefaultTopicQueueNums(4);
        //消息的重试次数
         //producer.setRetryTimesWhenSendFailed(4);
        //消息的压缩 消息超过多大了就开始压缩
        //producer.setCompressMsgBodyOverHowmuch();
        //设置消息的最大长度
        //producer.setMaxMessageSize(5);


        try {
            //启动服务
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //创建消息并发送
        for(int i=0;i<10;i++){
            //创建消息Message 一个topic 下面有4个队列 。可以在mq服务器上就行配置 6.7.8 个队列
            Message msg = new Message("mytopic"   , //主题
                    "TagA",     //tag  主题下的子标签
                    "myKey",  //key  可以是业务主键
                    ( "hellomq"+i).getBytes()  //消息body
            );
            //高级消息过滤用的条件
            msg.putUserProperty("criteria","1");
            System.out.print(msg.toString());
            //发送消息
            try {
                SendResult result = producer.send(msg);
                System.out.print(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        producer.shutdown();
    }
}
