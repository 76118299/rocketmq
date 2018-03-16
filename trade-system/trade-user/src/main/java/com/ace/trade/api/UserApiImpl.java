package com.ace.trade.api;

import com.ace.trade.protocl.user.ChangeUserMoneryReq;
import com.ace.trade.protocl.user.ChangeUserMoneryRes;
import com.ace.trade.protocl.user.QueryUserReq;
import com.ace.trade.protocl.user.QueryUserRes;
import com.ace.trade.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
@Controller
public class UserApiImpl implements IUserApi {
    @Autowired
    private IUserService userService;
    @RequestMapping("queryById")
    public QueryUserRes queryById(@RequestBody QueryUserReq req) {
        return null;
    }

    public ChangeUserMoneryRes changeUserMonery(ChangeUserMoneryReq req) {
        return null;
    }
}
