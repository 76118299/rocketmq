package com.ace.trade.service.serviceImpl;

import com.ace.trade.protocl.goods.QueryGoodsReq;
import com.ace.trade.protocl.goods.QueryGoodsRes;
import com.ace.trade.protocl.goods.ReduceGoodsReq;
import com.ace.trade.protocl.goods.ReduceGoodsRes;
import com.ace.trade.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.w3c.dom.ranges.RangeException;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    public GoodsServiceImpl(String s){

    }
    public QueryGoodsRes queryGoods(QueryGoodsReq req) {
        return null;
    }

    public ReduceGoodsRes ReduceGoods(ReduceGoodsReq req) {
        throw new RuntimeException();

    }
}
