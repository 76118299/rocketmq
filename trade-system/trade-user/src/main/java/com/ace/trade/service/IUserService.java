package com.ace.trade.service;

import com.ace.trade.protocl.user.ChangeUserMoneryReq;
import com.ace.trade.protocl.user.ChangeUserMoneryRes;
import com.ace.trade.protocl.user.QueryUserReq;
import com.ace.trade.protocl.user.QueryUserRes;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public interface IUserService {
    public QueryUserRes queryById(QueryUserReq req);
    public ChangeUserMoneryRes changeUserMonery(ChangeUserMoneryReq req);
}
