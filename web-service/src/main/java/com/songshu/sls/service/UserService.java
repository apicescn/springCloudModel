package com.songshu.sls.service;

import com.songshu.sls.mapper.UserMapper;
import com.songshu.sls.model.User;
import com.songshu.sls.model.UserInfo;
import com.songshu.sls.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String userId) {
        return this.userMapper.getUserById(userId);
    }

    public UserInfo getUserInfoByUserId(String userId) {
        return this.userMapper.getUserInfoByUserId(userId);

    }

    public int login(User user) {
        user.setLoginPass(StringUtils.getMD5String(user.getLoginPass()));//进行加密对比
        return this.userMapper.login(user);
    }

    public int updateUserById(User user) {
        return this.userMapper.updateUserById(user);
    }

    public int updateUserByIdSelective(User user) {
        return this.userMapper.updateUserByIdSelective(user);
    }

    public List<User> getUserListByDepartmentId(String departmentId) {
        return this.userMapper.getUserListByDepartmentId(departmentId);
    }

    public List<UserInfo> getUserListByRoleId(String roleId) {
        return this.userMapper.getUserListByRoleId(roleId);
    }

    public List<UserInfo> getUserListByGroupId(String groupId) {
        return this.userMapper.getUserListByGroupId(groupId);
    }

    public int deleteUserById(String id) {
        return this.userMapper.deleteUserById(id);
    }

    public int insertUser(User user) {
        return this.userMapper.insertUser(user);
    }

    public int insertUserSelective(User user) {
        return this.userMapper.insertUserSelective(user);
    }

    public int isExistUserByLoginName(String loginName) {
        return this.userMapper.isExistUserByLoginName(loginName);
    }

    public int deleteUserRoleByUserId(String userid) {
        return this.userMapper.deleteUserRoleByUserId(userid);
    }

    public int insertUserRole(Map<String, String> map) {
        return this.userMapper.insertUserRole(map);
    }

}
