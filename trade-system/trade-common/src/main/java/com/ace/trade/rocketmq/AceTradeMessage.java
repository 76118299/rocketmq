package com.ace.trade.rocketmq;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public class AceTradeMessage {

    public AceTradeMessage(){

    }


    private String topic;
    private String tag;
    private String key;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String body;
    private String criteria;




    @Override
    public String toString() {
        return "[topic:"+topic+"tag:"+tag+"key:"+key+" body:"+body+"]";
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) throws RocketMqException{
      if(null == topic){
          throw  new RocketMqException("topic not null");
      }
        this.topic = topic;

    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }


}
