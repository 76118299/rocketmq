package com.myrocketmq;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/3/10 0010.
 * 执行本地业务
 * 对数据进行本地数据库入库操作
 */

public class TransactionExcetorImpl implements LocalTransactionExecuter {
    /**
     * 入库操作
     * @param message
     * @param o
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message message, Object o) {
        try {
            System.out.print(message.toString());
            System.out.print("插入数据库数据："+ new String(message.getBody(),"utf-8"));
            System.out.print(message.getTags());
            System.out.print(message.getTopic());
            System.out.print(o.toString());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
