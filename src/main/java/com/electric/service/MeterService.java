package com.electric.service;

import com.electric.domain.Meter;

import java.util.List;

public interface MeterService {

    /**
     * 根据用户id查询电表信息
     * @param userId
     * @return
     */
    Meter getByUserId(Integer userId);

    /**
     * 查询全部
     * @return
     */
    List<Meter> getAll();

    /**
     * 更新电表
     * @param meter
     */
    void UpdateMeter(Meter meter);
}
