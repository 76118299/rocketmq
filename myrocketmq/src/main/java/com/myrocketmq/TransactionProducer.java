package com.myrocketmq;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.client.producer.TransactionSendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 发送事物消息
 * Created by Administrator on 2018/3/10 0010.
 */
public class TransactionProducer {

    public static void  main(String[] args){
        try {
        //创建事物消息组
        TransactionMQProducer transactionProducer = new TransactionMQProducer("transactionProducer");
        transactionProducer.setNamesrvAddr("");
        //事物回查最小并发
        transactionProducer.setCheckThreadPoolMinSize(4);
        //事物回查最大并发
        transactionProducer.setCheckThreadPoolMaxSize(5);
        //队列数量
        transactionProducer.setCheckRequestHoldMax(2000);
        /**
         * 如果 producer发送消息失败 MQ进行回查调用的方法
         *
         */
        transactionProducer.setTransactionCheckListener(new TransactionCheckListener() {
            @Override
            public LocalTransactionState checkLocalTransactionState(MessageExt messageExt) {
                System.out.print(""+messageExt.getBody());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });


            transactionProducer.start();


          for(int i=0;i<5;i++){
              Message message = new Message("TransactionTopic","TagB","TransactionKey",
                      ( "hellow mq"+i).getBytes());
              TransactionSendResult tq = transactionProducer.sendMessageInTransaction(message, new TransactionExcetorImpl(), "tq");

          }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
