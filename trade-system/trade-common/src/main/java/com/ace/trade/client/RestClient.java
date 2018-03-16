package com.ace.trade.client;


import com.ace.trade.api.IUserApi;
import com.ace.trade.protocl.user.QueryUserReq;
import com.ace.trade.protocl.user.QueryUserRes;
import com.ace.trade.protocl.user.ChangeUserMoneryReq;
import com.ace.trade.protocl.user.ChangeUserMoneryRes;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/3/13 0013.
 */
public class RestClient  implements IUserApi {
        private static RestTemplate restTemplate;

    public ChangeUserMoneryRes changeUserMonery(ChangeUserMoneryReq req) {
        return null;
    }

    public static void main(String[] args) {
        /************调用服务端接口的第一种做法************/
        QueryUserReq req = new QueryUserReq();
        Object forObject = restTemplate.postForObject("https://localhost:8080/user/queryById",req,QueryUserRes.class);
    }

    /**
     * 第二种做法就是实现其接口
     * @param req
     * @return
     */
    public QueryUserRes queryById(QueryUserReq req) {
        return restTemplate.postForObject("https://localhost:8080/user/queryById",req,QueryUserRes.class);
    }
}
