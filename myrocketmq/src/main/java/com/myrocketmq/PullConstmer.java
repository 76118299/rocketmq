package com.myrocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.consumer.PullStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/11 0011.
 * 主动拉取模式
 * 不是定时拉取
 */
public class PullConstmer {
    private static final Map<MessageQueue,Long> queueIndex = new HashMap<MessageQueue,Long>();
    public static void main(String[] args){
        try {
            DefaultMQPullConsumer pullConsumer = new DefaultMQPullConsumer("pullConsumer");
            pullConsumer.setNamesrvAddr("");
            pullConsumer.start();
            //从TopicPull主题下获取所有队列 默认4个
            Set<MessageQueue> mqs = pullConsumer.fetchMessageQueuesInBalance("TopicPull");
            //变量set集合
            for(MessageQueue mq:mqs){

                //遍历队列数据
                while (true){
                    //从队列中拉取数据
                    PullResult pullResult = pullConsumer.pullBlockIfNotFound(mq,null,getQueueIndex(mq),32);

                    //记录本次拉取数据的index 下次从这继续
                    setQueueIndex(mq,pullResult.getNextBeginOffset());

                    switch (pullResult.getPullStatus()){
                        case FOUND:
                            //读取数据
                            List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void setQueueIndex(MessageQueue queue,Long index){
        queueIndex.put(queue,index);
    }

    private static Long getQueueIndex(MessageQueue queue){
        Long index = queueIndex.get(queue);

        if(index !=null){
            return index;
        }

        return 0L;
    }
}
