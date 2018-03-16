package com.ace.trade.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public class AceTradeMQConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AceTradeMQConsumer.class);
    private String consumerGroupName;
    private String namesrvAddr;
    private String topic;
    private String tag="*";
    private String messgeFirstEnd="first";
    private String messageClusteringBrodcsting="brodcsting";
    private int threadMaxNum=9;
    private int ThreadMin=5;
    private IMessageHandler messageHandler;

    public String getConsumerGroupName() {
        return consumerGroupName;
    }

    public void setConsumerGroupName(String consumerGroupName) {
        this.consumerGroupName = consumerGroupName;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessgeFirstEnd() {
        return messgeFirstEnd;
    }

    public void setMessgeFirstEnd(String messgeFirstEnd) {
        this.messgeFirstEnd = messgeFirstEnd;
    }

    public String getMessageClusteringBrodcsting() {
        return messageClusteringBrodcsting;
    }

    public void setMessageClusteringBrodcsting(String messageClusteringBrodcsting) {
        this.messageClusteringBrodcsting = messageClusteringBrodcsting;
    }

    public int getThreadMaxNum() {
        return threadMaxNum;
    }

    public void setThreadMaxNum(int threadMaxNum) {
        this.threadMaxNum = threadMaxNum;
    }

    public int getThreadMin() {
        return ThreadMin;
    }

    public void setThreadMin(int threadMin) {
        ThreadMin = threadMin;
    }

    public IMessageHandler getMessageHandler() {
        return messageHandler;
    }

    public void setMessageHandler(IMessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void  init() throws RocketMqException {
        if(null ==consumerGroupName){
            throw  new RocketMqException("consumerGroupName not null");
        }
        if(null == namesrvAddr){
            throw  new RocketMqException("namesrvAddr not null");
        }
        if(null == topic){
            throw  new RocketMqException("topic not null");
        }
        DefaultMQPushConsumer aceTradeMQConsumer = new DefaultMQPushConsumer();
        aceTradeMQConsumer.setConsumeThreadMax(threadMaxNum);
        aceTradeMQConsumer.setConsumeThreadMin(ThreadMin);
        aceTradeMQConsumer.setNamesrvAddr(namesrvAddr);
        if(null !=messgeFirstEnd){
            if(messgeFirstEnd.equals("first")){
                aceTradeMQConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            }else if(messgeFirstEnd.equals("end")){
                aceTradeMQConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            }else{
                aceTradeMQConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            }
        }
        if(null !=messageClusteringBrodcsting){
            if(messageClusteringBrodcsting.equals("Clustering")){
                aceTradeMQConsumer.setMessageModel(MessageModel.CLUSTERING);
            }else if(messageClusteringBrodcsting.equals("Brodcsting")){
                aceTradeMQConsumer.setMessageModel(MessageModel.BROADCASTING);
            }else {
                aceTradeMQConsumer.setMessageModel(MessageModel.CLUSTERING);
            }
        }
        try {
           AceMessageListener messageListener= new AceMessageListener();
            messageListener.setMessageHandler(messageHandler);
            aceTradeMQConsumer.subscribe(topic,tag);
            aceTradeMQConsumer.registerMessageListener(messageListener);
            aceTradeMQConsumer.start();
            LOGGER.info("consumer start resource ");
        } catch (MQClientException e) {
            e.printStackTrace();
            LOGGER.info("consumer start error ");
            throw  new RocketMqException("rocketmq MQClientException 异常");
        }



    }

}
