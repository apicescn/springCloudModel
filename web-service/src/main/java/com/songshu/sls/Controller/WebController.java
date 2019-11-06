package com.songshu.sls.Controller;

import com.songshu.sls.model.User;
import com.songshu.sls.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController是特殊的Controller，他的返回值直接作为Http Response的Body部分返回给浏览器
@RestController
public class WebController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUser/{userId}",method=RequestMethod.GET )
    public User findUser(@PathVariable String userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user",user);
        return user;
    }

    @RequestMapping(value = "/findUserList/{departmentId}",method = RequestMethod.GET)
    public List<User> findDeptUserList(@PathVariable String departmentId) {
        return userService.getUserListByDepartmentId(departmentId);
    }
}