package com.electric.service.impl;

import com.electric.domain.Meter;
import com.electric.mapper.MeterMapper;
import com.electric.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeterServiceImpl implements MeterService {

    @Autowired
    private MeterMapper meterMapper;

    /**
     * 根据用户id查询电表
     * @param userId
     * @return
     */
    @Override
    public Meter getByUserId(Integer userId) {
        return meterMapper.getByUserId(userId);
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Meter> getAll() {
        return meterMapper.getAll();
    }

    /**
     * 更新电表
     * @param meter
     */
    @Override
    public void UpdateMeter(Meter meter) {
        meterMapper.updateMeter(meter);
    }
}
