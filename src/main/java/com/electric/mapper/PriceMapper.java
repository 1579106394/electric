package com.electric.mapper;

import com.electric.domain.Page;
import com.electric.domain.Price;

import java.util.List;

public interface PriceMapper {

    /**
     * 根据月份查询电价
     * @param now
     * @return
     */
    Price getByMonth(String now);

    /**
     * 插入电价
     * @param price
     */
    void addPrice(Price price);

    /**
     *  更新电价
     * @param p
     */
    void updatePrice(Price p);

    /**
     * 分页查询电价
     * @param p
     * @return
     */
    List<Price> getListByPage(Page<Price> p);

    /**
     * 查询数量
     * @param p
     * @return
     */
    int getCountByPage(Page<Price> p);
}
