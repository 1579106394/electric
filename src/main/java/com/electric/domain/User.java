package com.electric.domain;

import java.io.Serializable;

/**
 * 用户表
 * CREATE TABLE `user` (
 *   `user_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(20) DEFAULT NULL,
 *   `password` varchar(20) DEFAULT NULL,
 *   `user_name` varchar(20) DEFAULT NULL,
 *   `user_age` int(3) DEFAULT NULL,
 *   `user_sex` int(1) DEFAULT NULL,
 *   `user_phone` varchar(13) DEFAULT NULL,
 *   `user_money` double DEFAULT '0' COMMENT '电费',
 *   `user_flag` int(2) DEFAULT NULL COMMENT '身份，1普通用户，2管理员',
 *   PRIMARY KEY (`user_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String password;
    private String userName;
    private Integer userAge;
    private Integer userSex;
    private String userPhone;
    private Double userMoney;
    private Integer userFlag;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
