package com.ace.trade.utils;

import java.util.UUID;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class IDGenerate {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
