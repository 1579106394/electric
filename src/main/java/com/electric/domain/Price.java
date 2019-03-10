package com.electric.domain;

import java.io.Serializable;

/**
 * 电价表
 * CREATE TABLE `price` (
 *   `price_id` int(11) NOT NULL,
 *   `price_money` double DEFAULT NULL COMMENT '电价',
 *   `price_month` varchar(30) DEFAULT NULL COMMENT '月份',
 *   PRIMARY KEY (`price_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Price implements Serializable {

    private Integer priceId;
    private Double priceMoney;
    private String priceMonth;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Double getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(Double priceMoney) {
        this.priceMoney = priceMoney;
    }

    public String getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(String priceMonth) {
        this.priceMonth = priceMonth;
    }
}
