package com.ace.trade.constant;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public enum  TradeEnum {
    TE_200("处理成功",200),
    TE_500("处理异常",500);


    private TradeEnum(String name,int index){
        this.name=name;
        this.index=index;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String name;
    private int index;


}
