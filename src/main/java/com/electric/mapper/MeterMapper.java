package com.electric.mapper;

import com.electric.domain.Meter;

import java.util.List;

public interface MeterMapper {

    /**
     * 新增电表
     * @param meter
     */
    void addMeter(Meter meter);

    /**
     * 根据用户id删除
     * @param userId
     */
    void deleteByUserId(Integer userId);

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
    void updateMeter(Meter meter);
}
