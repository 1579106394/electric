package com.electric.mapper;

import com.electric.domain.Money;
import com.electric.domain.Page;

import java.util.List;

public interface MoneyMapper {

    /**
     * 新增电费记录（缴费）
     * @param money
     */
    void addMoney(Money money);

    /**
     * 查询列表
     * @param p
     * @return
     */
    List<Money> getListByPage(Page<Money> p);

    /**
     * 查询数量
     * @param p
     * @return
     */
    int getCountByPage(Page<Money> p);

    /**
     * 根据id删除
     * @param moneyId
     */
    void deleteById(Integer moneyId);
}
