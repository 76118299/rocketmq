package com.ace.trade.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.alibaba.rocketmq.shade.io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public class AceTradeMQProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(AceTradeMQProducer.class);

    private DefaultMQProducer producer;
    private String producerGroupName;
    private String namesrvAddr ;
    private int maxMessgeSize = 1024*1024*4;
    private int sendMsgTimeout=5;
    private int retryTimesWhenSendFailed=3;



    public void init() throws RocketMqException {
        if(StringUtils.isBlank(producerGroupName)){
            throw  new RocketMqException("producerGroupName is null");
        }
        if(StringUtils.isBlank(namesrvAddr)){
            throw  new RocketMqException("namesrvAddr is null");
        }
        producer = new DefaultMQProducer(producerGroupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setMaxMessageSize(maxMessgeSize);
        producer.setSendMsgTimeout(sendMsgTimeout);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);


        try {
            producer.start();
            LOGGER.info(String.format("rocketmq start groupName:[%s],namesrvAddr:[%s]",producerGroupName,namesrvAddr));
        } catch (MQClientException e) {
            LOGGER.error(String.format("rocketmq start error!!! groupName:[%s],namesrvAddr:[%s]",producerGroupName,namesrvAddr));
            e.printStackTrace();
            throw  new RocketMqException(e);
        }
    }

    public SendResult sendMessage(AceTradeMessage msg) throws RocketMqException {
        Message message = new Message(msg.getTopic(),msg.getTag(),msg.getKey(),msg.getBody().getBytes());
        try {
            SendResult sendResult = producer.send(message);
            return sendResult;
        } catch (Exception e) {
            throw  new RocketMqException("发送消息失败："+msg.toString());
        }

    }


    public DefaultMQProducer getProducer() {
        return producer;
    }

    public void setProducer(DefaultMQProducer producer) {
        this.producer = producer;
    }

    public String getProducerGroupName() {
        return producerGroupName;
    }

    public void setProducerGroupName(String producerGroupName) {
        this.producerGroupName = producerGroupName;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public int getMaxMessgeSize() {
        return maxMessgeSize;
    }

    public void setMaxMessgeSize(int maxMessgeSize) {
        this.maxMessgeSize = maxMessgeSize;
    }

    public int getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(int sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public int getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public void setRetryTimesWhenSendFailed(int retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
    }



}
