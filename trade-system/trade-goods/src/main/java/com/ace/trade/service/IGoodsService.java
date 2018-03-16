package com.ace.trade.service;

import com.ace.trade.protocl.goods.QueryGoodsReq;
import com.ace.trade.protocl.goods.QueryGoodsRes;
import com.ace.trade.protocl.goods.ReduceGoodsReq;
import com.ace.trade.protocl.goods.ReduceGoodsRes;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
public interface IGoodsService {
    public QueryGoodsRes queryGoods(QueryGoodsReq req);
    public ReduceGoodsRes ReduceGoods(ReduceGoodsReq req);
}
