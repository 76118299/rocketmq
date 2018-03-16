package com.ace.trade.service.serviceimpl;

import com.ace.trade.protocl.user.ChangeUserMoneryReq;
import com.ace.trade.protocl.user.ChangeUserMoneryRes;
import com.ace.trade.protocl.user.QueryUserReq;
import com.ace.trade.protocl.user.QueryUserRes;
import com.ace.trade.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
@Service
public class UserServiceImpl implements IUserService {
    public QueryUserRes queryById(QueryUserReq req) {

        return null;
    }
    @Transactional
    public ChangeUserMoneryRes changeUserMonery(ChangeUserMoneryReq req) {
        try{
            //记录日志表
            //  订单付款
            /**
             *  订单退款的逻辑
             *  首先查询是否有付款记录
             *  防止多次退款
             */



        }catch (Exception e){

        }

        return null;
    }
}
