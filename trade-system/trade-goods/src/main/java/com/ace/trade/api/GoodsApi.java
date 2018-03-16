package com.ace.trade.api;

import com.ace.trade.protocl.goods.QueryGoodsReq;
import com.ace.trade.protocl.goods.QueryGoodsRes;
import com.ace.trade.protocl.goods.ReduceGoodsReq;
import com.ace.trade.protocl.goods.ReduceGoodsRes;
import com.ace.trade.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
@Controller
public class GoodsApi implements IGoodsApi {
    @Autowired
    IGoodsService goodsService;
    @RequestMapping(value = "/queryGoods",method = RequestMethod.POST)
    @ResponseBody
    public QueryGoodsRes queryGoods(@RequestBody QueryGoodsReq req) {
        return null;
    }
    @RequestMapping(value = "/ReduceGoods", method = RequestMethod.POST)
    @ResponseBody
    public ReduceGoodsRes ReduceGoods(@RequestBody ReduceGoodsReq req) {
        goodsService.ReduceGoods(req);
        return null;
    }
}
