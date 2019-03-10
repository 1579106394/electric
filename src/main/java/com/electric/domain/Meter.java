package com.electric.domain;

import java.io.Serializable;

/**
 * 电表表
 * CREATE TABLE `meter` (
 *   `meter_id` int(11) NOT NULL AUTO_INCREMENT,
 *   `meter_user` int(11) DEFAULT NULL COMMENT '用户',
 *   `meter_start_num` double DEFAULT NULL COMMENT '本月月初电表始码',
 *   `meter_current_num` double DEFAULT NULL COMMENT '本月当前电表止码',
 *   `meter_num` double DEFAULT NULL COMMENT '本月当前用电量',
 *   `meter_money` double DEFAULT NULL COMMENT '本月当前电费',
 *   PRIMARY KEY (`meter_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Meter implements Serializable {

    private Integer meterId;
    private User user;
    private Double meterStartNum;
    private Double meterCurrentNum;
    private Double meterNum;
    private Double meterMoney;

    public Integer getMeterId() {
        return meterId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getMeterStartNum() {
        return meterStartNum;
    }

    public void setMeterStartNum(Double meterStartNum) {
        this.meterStartNum = meterStartNum;
    }

    public Double getMeterCurrentNum() {
        return meterCurrentNum;
    }

    public void setMeterCurrentNum(Double meterCurrentNum) {
        this.meterCurrentNum = meterCurrentNum;
    }

    public Double getMeterNum() {
        return meterNum;
    }

    public void setMeterNum(Double meterNum) {
        this.meterNum = meterNum;
    }

    public Double getMeterMoney() {
        return meterMoney;
    }

    public void setMeterMoney(Double meterMoney) {
        this.meterMoney = meterMoney;
    }
}
