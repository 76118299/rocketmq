package com.ace.trade.api;

import com.ace.trade.protocl.goods.QueryGoodsReq;
import com.ace.trade.protocl.goods.QueryGoodsRes;
import com.ace.trade.protocl.goods.ReduceGoodsReq;
import com.ace.trade.protocl.goods.ReduceGoodsRes;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public interface IGoodsApi {
    public QueryGoodsRes queryGoods(QueryGoodsReq req);
    public ReduceGoodsRes ReduceGoods(ReduceGoodsReq req);
}
