package com.songshu.sls.mapper;

import com.songshu.sls.model.User;
import com.songshu.sls.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/27.
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户Id获得用户信息
     * @param userId
     * @return
     */
    public User getUserById(String userId);

    /**
     * 根据用户Id(包括loginName)获得UserInfo信息(只是和user映射字段含义不同，便于Web前台调用而已)
     * @param userId
     * @return
     */
    public UserInfo getUserInfoByUserId(String userId);

    /**
     * 根据部门Id获得该部门下的所有用户 信息列表
     * @param departmentId
     * @return
     */
    List<User> getUserListByDepartmentId(String departmentId);

    /**
     * 根据角色id查找用户列表
     * @param roleId
     * @return
     */
    public List<UserInfo> getUserListByRoleId(String roleId);

    /**
     * 根据工作组id查找用户列表
     * @param groupId
     * @return
     */
    public List<UserInfo> getUserListByGroupId(String groupId);

    /**
     * 用户登录验证信息
     * @param user
     */
    public int login(User user);

    /**
     * 更新用户信息(需传入全部字段)
     * @param user
     */
    public int updateUserById(User user);

    /**
     * 更新用户信息(根据传入的字段进行动态更新)
     * @param user
     */
    public int updateUserByIdSelective(User user);

    /**
     * 创建新用户(需传入全部字段)
     * @param user
     * @return
     */
    public  int insertUser(User user);

    /**
     * 创建新用户(根据传入的字段进行动态增加)
     * @param user
     * @return
     */
    public  int insertUserSelective(User user);

    /**
     * 根据用户ID删除用户信息
     * @param id
     */
    public int deleteUserById(String id);

    /**
     * 判断用户登陆名是否已存在
     * @param loginName
     * @return
     */
    public int isExistUserByLoginName(String loginName);

    /**
     * 根据用户ID删除角色信息
     * @param userid
     * @return
     */
    public int deleteUserRoleByUserId(String userid);

    /**
     * 新建用户角色信息
     * @param map
     * @return
     */
    public int insertUserRole(Map<String, String> map);

}
