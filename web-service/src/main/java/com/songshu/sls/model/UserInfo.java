package com.songshu.sls.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 7678659668879503882L;
	
	public static final String USER_INFO_KEY = "userInfo";//为了casFilter初始化获得session信息所用
	
	String userId;
	String userName;
	String loginName;
	String password;
	String male;
	String disabled;	
	String deptId;
	String deptName;
	String deptFullName;
	String parentDeptId;
	String parentDeptName;
	String privDeptId;//用户的权限部门编码
	String privDeptName;//用户权限部门简称
	String privDeptFullName;//用户的权限部门名称
	String sort;
	BigDecimal status;
	String ismember;
}
