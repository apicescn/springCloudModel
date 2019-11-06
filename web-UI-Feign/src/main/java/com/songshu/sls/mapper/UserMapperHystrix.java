package com.songshu.sls.mapper;

import com.songshu.sls.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

/**
 * Created by Allen on 2017/4/27.
 */
@Component
public class UserMapperHystrix  implements UserMapper{

    @Override
    public User getUserById(@PathVariable(value = "userId") String userId) {
        return new User();
    }

    @Override
    public List<User> getUserListByDepartmentId(@PathVariable(value = "departmentId") String departmentId) {
        List<User> userList = new ArrayList<User>();
        return userList;
    }

    @Override
    public String info() {
        return "服务异常，未能正常通讯，请检查服务是否正常！";
    }
}
