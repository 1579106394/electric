package com.electric.service;

import com.electric.domain.Money;
import com.electric.domain.Page;

public interface MoneyService {

    /**
     * 新增电费记录（充值）
     * @param money
     */
    void addMoney(Money money);

    /**
     * 分页查询
     * @param p
     * @return
     */
    Page<Money> getByPage(Page<Money> p);

    /**
     * 根据id删除
     * @param moneyId
     */
    void deleteById(Integer moneyId);
}
