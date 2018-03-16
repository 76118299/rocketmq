package com.ace.trade.api;

import com.ace.trade.protocl.coupon.ChangeCouponStatusReq;
import com.ace.trade.protocl.coupon.QueryCouponReq;
import com.ace.trade.protocl.coupon.QueryCouponRes;

import com.ace.trade.protocl.coupon.ChangeCouponStatusRes;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public interface ICouponApi {
    public QueryCouponRes queryCoupon(QueryCouponReq req);

    public ChangeCouponStatusRes changeCouponStatus(ChangeCouponStatusReq req);
}
