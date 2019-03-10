package com.electric.domain;

import java.io.Serializable;

/**
 * 充值记录表
 * CREATE TABLE `money` (
 *   `money_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `money_user` int(11) DEFAULT NULL,
 *   `money_time` varchar(30) DEFAULT NULL,
 *   `money_money` double DEFAULT NULL,
 *   PRIMARY KEY (`money_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Money implements Serializable {

    private Integer moneyId;
    private User user;
    private String moneyTime;
    private Double moneyMoney;

    public Integer getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(Integer moneyId) {
        this.moneyId = moneyId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(String moneyTime) {
        this.moneyTime = moneyTime;
    }

    public Double getMoneyMoney() {
        return moneyMoney;
    }

    public void setMoneyMoney(Double moneyMoney) {
        this.moneyMoney = moneyMoney;
    }
}
