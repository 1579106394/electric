package com.electric.service.impl;

import com.electric.domain.Money;
import com.electric.domain.Page;
import com.electric.domain.User;
import com.electric.mapper.MoneyMapper;
import com.electric.mapper.UserMapper;
import com.electric.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 新增电费记录
     * @param money
     */
    @Override
    public void addMoney(Money money) {
        // 设置当前时间
        money.setMoneyTime(new SimpleDateFormat("yyyy-MM").format(new Date()));
        moneyMapper.addMoney(money);
        // 缴费成功，对应的用户电费要增加这个数值
        User user = userMapper.getById(money.getUser().getUserId());
        user.setUserMoney(user.getUserMoney()+money.getMoneyMoney());
        userMapper.updateUser(user);
    }

    /**
     * 分页查询
     * @param p
     * @return
     */
    @Override
    public Page<Money> getByPage(Page<Money> p) {
        // 当前页如果为空，则设置为1
        if (p.getCurrentPage() == null) {
            p.setCurrentPage(1);
        }
        // 设置每页显示条数为15，每页索引在这个set方法里自动封装
        p.setCurrentCount(15);
        // 根据page分页查询数据列表
        List<Money> list = moneyMapper.getListByPage(p);
        // 数据放到p中
        p.setList(list);
        // 查询总条数
        int count = moneyMapper.getCountByPage(p);
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

    /**
     * 根据id删除
     * @param moneyId
     */
    @Override
    public void deleteById(Integer moneyId) {
        moneyMapper.deleteById(moneyId);
    }
}
