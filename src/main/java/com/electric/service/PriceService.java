package com.electric.service;

import com.electric.domain.Page;
import com.electric.domain.Price;

public interface PriceService {

    /**
     * 发布电费
     * @param price
     */
    void addPrice(Price price);

    /**
     * 分页查询电价
     * @param p
     * @return
     */
    Page<Price> getByPage(Page<Price> p);

    /**
     * 查询指定月份电价
     * @param month
     * @return
     */
    Price getByMonth(String month);
}
