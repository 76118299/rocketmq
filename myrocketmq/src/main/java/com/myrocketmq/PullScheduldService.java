package com.myrocketmq;

import com.alibaba.rocketmq.client.consumer.*;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * Created by Administrator on 2018/3/11 0011.
 * 主动拉取模式 定时拉取
 */
public class PullScheduldService {
    public static void  main(String[] args){
        MQPullConsumerScheduleService scheduleService = new MQPullConsumerScheduleService("schedulPullConstmer");

        scheduleService.getDefaultMQPullConsumer().setNamesrvAddr("");
        //操作为集群模式
        scheduleService.setMessageModel(MessageModel.CLUSTERING);
        //注册监听并回调
        scheduleService.registerPullTaskCallback("SchedulTopic",
                new PullTaskCallback() {
                    @Override
                    public void doPullTask(MessageQueue mq, PullTaskContext pullTaskContext) {
                        MQPullConsumer consumer = pullTaskContext.getPullConsumer();
                        //获取从哪里拉取数据
                        try {
                            long index = consumer.fetchConsumeOffset(mq, false);
                            PullResult pustatus = consumer.pull(mq, "*", index, 5);
                            switch (pustatus.getPullStatus()){
                                case FOUND:
                                    //读取数据
                                    List<MessageExt> msgFoundList = pustatus.getMsgFoundList();
                                    for(MessageExt ext : msgFoundList){
                                        System.out.print(ext.getBody());
                                    }

                                    break;
                                case NO_NEW_MSG:
                                    break;
                                case NO_MATCHED_MSG:
                                    break;
                                case OFFSET_ILLEGAL:
                                    break;
                                default:
                                    break;


                            }
                                //更新队列下标读取到哪了 每隔5秒 同步到MQ服务器
                            consumer.updateConsumeOffset(mq,pustatus.getNextBeginOffset());

                            //设置定时的间隔时间
                            pullTaskContext.setPullNextDelayTimeMillis(300);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

    }
}
