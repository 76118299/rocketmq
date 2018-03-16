package com.ace.trade.api;

import com.ace.trade.protocl.user.QueryUserReq;
import com.ace.trade.protocl.user.QueryUserRes;
import com.ace.trade.protocl.user.ChangeUserMoneryReq;
import com.ace.trade.protocl.user.ChangeUserMoneryRes;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public interface IUserApi {
    public QueryUserRes queryById(QueryUserReq req);
    public ChangeUserMoneryRes changeUserMonery(ChangeUserMoneryReq req);
}
