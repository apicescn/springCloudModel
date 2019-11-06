package com.songshu.sls.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class User {

    private String userId;

    private String userName;

    private String loginName;

    private String loginPass;

    private String male;

    private String deptId;

    private String disabled;

    private String nick;

    private String portrait;

    private BigDecimal status;

    private String ip;

    private String extDeptId;

    private BigDecimal isWork;

    private String sort;

    private String isMember;

    private Date createDate;

    private Date updateTime;

    private String tj;
}