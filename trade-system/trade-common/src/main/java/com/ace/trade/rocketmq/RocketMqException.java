package com.ace.trade.rocketmq;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public class RocketMqException extends Exception {
    public RocketMqException() {
        super();
    }

    public RocketMqException(String message) {
        super(message);
    }

    public RocketMqException(String message, Throwable cause) {
        super(message, cause);
    }

    public RocketMqException(Throwable cause) {
        super(cause);
    }
}
