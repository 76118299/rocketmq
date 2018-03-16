package com.ace.trade.service.serviceImpl;

import com.ace.trade.api.ICouponApi;
import com.ace.trade.api.IGoodsApi;
import com.ace.trade.api.IUserApi;
import com.ace.trade.protocl.coupon.ChangeCouponStatusReq;
import com.ace.trade.protocl.goods.ReduceGoodsReq;
import com.ace.trade.protocl.mq.CancelOrderMq;
import com.ace.trade.protocl.order.ConfirmOrderReq;
import com.ace.trade.protocl.order.ConfirmOrderRes;
import com.ace.trade.protocl.user.ChangeUserMoneryReq;
import com.ace.trade.rocketmq.AceTradeMQProducer;
import com.ace.trade.rocketmq.AceTradeMessage;
import com.ace.trade.rocketmq.RocketMqException;
import com.ace.trade.service.IOrderService;
import com.alibaba.rocketmq.shade.com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IUserApi userApi;
    @Autowired
    private ICouponApi couponApi;
    @Autowired
    private IGoodsApi goodsApi;
    @Autowired
    private AceTradeMQProducer producer;
    /**
     * 创建不可见订单 并调用远程服务
     * @param req
     * @return
     */
    public ConfirmOrderRes confirmOrder( ConfirmOrderReq req) {
        ConfirmOrderRes res = new ConfirmOrderRes();
        try {
            //1.检查校验
            checkConfirmOrderReq(req);
            //2.创建不可见订单
            saveNoconfirmOrder(req);
            //3.调用远程服务  调用远程服务 如： 扣优惠券，检查库存 扣余额  如果都校验成功了就更改订单状态为可见
            //如果失败就发送MQ消息取消订单


            callRemoteService(req);
        }catch (Exception e){
            //设置异常返回消息
        }
        //返回结果
        return res;
    }

    /**
     * 创建不可见订单
     * @param req
     */
    private void saveNoconfirmOrder(ConfirmOrderReq req) {
    }

    /**
     * 检查校验
     * @param req
     */
    private void checkConfirmOrderReq(ConfirmOrderReq req) {

    }

    /**
     * 调用远程服务
     * @param req
     */
    private void callRemoteService(ConfirmOrderReq req)  {
        try {
            //扣款
            ChangeUserMoneryReq cmr = new ChangeUserMoneryReq();
            userApi.changeUserMonery(cmr);
            //使用优惠券
            ChangeCouponStatusReq ccr = new ChangeCouponStatusReq();
            couponApi.changeCouponStatus(ccr);
            //扣库存
            ReduceGoodsReq rgr = new ReduceGoodsReq();
            goodsApi.ReduceGoods(rgr);

            //如果都成功了更改订单状态 为可见


        }catch (Exception e){
        //调用远程服务失败给发送MQ消息
            try {
            AceTradeMessage atm = new AceTradeMessage();
                atm.setTopic("Roolback");
                atm.setTag("");
                atm.setKey("");//订单ID
                CancelOrderMq com = new CancelOrderMq();
                atm.setBody(JSON.toJSONString(com));
                producer.sendMessage(atm);
            } catch (RocketMqException e1) {
                e1.printStackTrace();
            }

        }
    }


}
