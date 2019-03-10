package com.electric.service.impl;

import com.electric.domain.Page;
import com.electric.domain.Price;
import com.electric.mapper.PriceMapper;
import com.electric.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;

    /**
     * 发布电价
     * @param price
     */
    @Override
    public void addPrice(Price price) {
        // 获得当前月
        String now = new SimpleDateFormat("yyyy-MM").format(new Date());
        // 先根据月份查询到电价信息，如果查不到就插入，如果查到了就更新
        Price p = priceMapper.getByMonth(now);
        if(p==null) {
            // 设置当前月
            price.setPriceMonth(now);
            priceMapper.addPrice(price);
        }else {
            // 更新电价
            p.setPriceMoney(price.getPriceMoney());
            priceMapper.updatePrice(p);
        }
    }

    /**
     * 分页查询电价
     * @param p
     * @return
     */
    @Override
    public Page<Price> getByPage(Page<Price> p) {
        // 当前页如果为空，则设置为1
        if (p.getCurrentPage() == null) {
            p.setCurrentPage(1);
        }
        // 设置每页显示条数为15，每页索引在这个set方法里自动封装
        p.setCurrentCount(15);
        // 根据page分页查询数据列表
        List<Price> list = priceMapper.getListByPage(p);
        // 数据放到p中
        p.setList(list);
        // 查询总条数
        int count = priceMapper.getCountByPage(p);
        // 封装总条数
        p.setTotalCount(count);
        // 计算总页数，总页数为总条数/每页显示条数，如果有余数，就再加一
        int totalPage = count / 15;
        if (count % 15 > 0) {
            totalPage++;
        }
        p.setTotalPage(totalPage);
        return p;
    }

    @Override
    public Price getByMonth(String month) {
        return priceMapper.getByMonth(month);
    }
}
