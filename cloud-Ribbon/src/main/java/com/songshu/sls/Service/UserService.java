package com.songshu.sls.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.songshu.sls.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/5/18.
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    //fallbackMetod的方法必须和本方法参数及返回类型一致。
    @HystrixCommand(fallbackMethod = "findServiceFallback")
    public User findUserService(@PathVariable(value = "userId") String userId) {
        return restTemplate.getForEntity("http://web-service:9000/findUser/"+userId, User.class).getBody();
    }
    public User findServiceFallback(@PathVariable(value = "userId") String userId) {
        return new User();
    }


}
