package com.songshu.sls.Controller;

import com.songshu.sls.mapper.UserMapper;
import com.songshu.sls.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Allen on 2017/4/27.
 */
//.@Restroller是特殊的Controller，他的返回值直接作为Http Response的Body部分返回给浏览器
@RestController
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable(value = "userId") String usserId) {
        return userMapper.getUserById(usserId);
    }

    @RequestMapping(value = "/findUserList/{departmentId}", method = RequestMethod.GET)
    public List<User> findDeptUserList(@PathVariable(value = "departmentId") String departmentId) {
        return userMapper.getUserListByDepartmentId("10000101");
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info() {
        return userMapper.info();
    }
}
