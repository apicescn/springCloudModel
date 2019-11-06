package com.songshu.sls.mapper;

import com.songshu.sls.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Allen on 2017/4/27.
 */
@FeignClient(value = "web-service",fallback = UserMapperHystrix.class)
public interface UserMapper {

    @RequestMapping(method = RequestMethod.GET, value = "/findUser/{userId}")
    public User getUserById(@PathVariable(value = "userId") String userId);

    @RequestMapping(method = RequestMethod.GET, value = "/findUserList/{departmentId}")
    List<User> getUserListByDepartmentId(@PathVariable(value = "departmentId") String departmentId);

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  String  info();

}
