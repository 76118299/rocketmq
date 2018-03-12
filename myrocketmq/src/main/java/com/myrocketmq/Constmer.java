package com.myrocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.MixAll;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageConst;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10 0010.
 * 消息消费者
 *
 */
public class Constmer {
    public static void main(String[] args){
        /**
         *
         * 消费者的两种模式
         *  DefaultMQPushConsumer  :  被动推模式(由MQ服务器自己推送)
         *   DefaultMQPullConsumer :  主动拉取模式（去mq服务器上中）
         */

        //创建消息消费者  *****groupName是做负载均衡用的（就是多个机器用同一个groupNme 这样 MQ就可以负载多个机器了）*******
        //多台集群部署相同程序 就是一个组的了 就是负载了 可以获取一个主题的消息
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("mymqgroup");
        //设置消息模式 rocketMQ有两种消息模式 集群模式和 广播模式
        consumer.setMessageModel(MessageModel.CLUSTERING);  //设置集群模式  默认是集群模式
        //广播模式
        // consumer.setMessageModel(MessageModel.BROADCASTING);  如果是广播模式 那么 所有的constmer 消费者 都会接收到同一个消息
        //绑定nameserver地址
        consumer.setNamesrvAddr("192.168.1.1:9876;192.168.1.2:9876");
        //设置消费的位置 是从头开始还是从尾部开始
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //设置消费者订阅主题
        try {
            //简单消息过滤：
            //例子 consumer.subscribe("mytopic","taga||tagb") 匹配tag taga或者tagb
            //第二个参数是 正则 *表示匹配所有
            consumer.subscribe("mytopic","*");  //可以订阅多个主题 consumer.subscribe("mytopic1","*");

            //高级条件过滤
            // consumer.subscribe("topic" ,"类路径","java文件转换的string");
            //String javaString = MixAll.file2String("E:/rocketmq/myrocketmq/src/main/java/com/myrocketmq/MessageFilterImpl");
            //consumer.subscribe("topic" ,"com.myrocketmq.MessageFilterImpl",javaString);


        } catch (MQClientException e) {
            e.printStackTrace();
        }
        //注册消息监听
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            /**
             *
             * @param msgs list可以支持批量消费
             * @param consumeConcurrentlyContext
             * @return
             */
            MessageExt messageExt=null;
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try {
                    //消息监听并接收
                 messageExt = msgs.get(0);
                String topic = messageExt.getTopic();
                String tags = messageExt.getTags();
                String body = new String(messageExt.getBody(),"utf-8");

                    //消息重试会取到原始ID
                    messageExt.getProperties().get(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID);

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    //说明消息没有被重试
                    if(messageExt.getReconsumeTimes()==0){
                    //消息重试3次
                    }else if(messageExt.getReconsumeTimes()==3){
                        //自己的业务处理
                        return  ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    }
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }


        });

        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
