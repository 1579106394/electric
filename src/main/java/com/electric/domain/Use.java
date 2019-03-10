package com.electric.domain;

import java.io.Serializable;

/**
 * 用电记录表
 * CREATE TABLE `use` (
 *   `use_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `use_user` int(11) DEFAULT NULL,
 *   `use_money` double DEFAULT NULL COMMENT '电费费用',
 *   `use_number` double DEFAULT NULL COMMENT '用电多少度',
 *   `use_time` varchar(30) DEFAULT NULL COMMENT '月份',
 *   PRIMARY KEY (`use_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Use implements Serializable {

    private Integer useId;
    private User user;
    private Double useMoney;
    private Double useNumber;
    private String useTime;

    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(Double useMoney) {
        this.useMoney = useMoney;
    }

    public Double getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(Double useNumber) {
        this.useNumber = useNumber;
    }

    public String getUseTime() {
        return useTime;
    }

    public void setUseTime(String useTime) {
        this.useTime = useTime;
    }
}
