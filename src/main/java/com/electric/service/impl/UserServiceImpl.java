package com.electric.service.impl;

import com.electric.domain.Meter;
import com.electric.domain.Page;
import com.electric.domain.User;
import com.electric.mapper.MeterMapper;
import com.electric.mapper.UserMapper;
import com.electric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MeterMapper meterMapper;

    /**
     * 根据用户名获取用户
     *
     * @param username
     * @return
     */
    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        // 设置默认属性：money为0，flag为1（用户）
        user.setUserMoney(0D);
        user.setUserFlag(1);
        userMapper.addUser(user);
        // 新增成功后，给该用户分配一个电表
        Meter meter = new Meter();
        meter.setUser(user);
        // 其余全部默认为0
        meter.setMeterStartNum(0D);
        meter.setMeterCurrentNum(0D);
        meter.setMeterNum(0D);
        meter.setMeterMoney(0D);
        meterMapper.addMeter(meter);
    }

    /**
     * 根据page分页查询
     *
     * @param p
     * @return
     */
    @Override
    public Page<User> getByPage(Page<User> p) {
        // 当前页如果为空，则设置为1
        if (p.getCurrentPage() == null) {
            p.setCurrentPage(1);
        }
        // 设置每页显示条数为15，每页索引在这个set方法里自动封装
        p.setCurrentCount(15);
        // 根据page分页查询数据列表
        List<User> list = userMapper.getListByPage(p);
        // 数据放到p中
        p.setList(list);
        // 查询总条数
        int count = userMapper.getCountByPage(p);
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
     */
    @Override
    public void deleteById(Integer userId) {
        userMapper.deleteById(userId);
        // 删除成功后，将这个用户id对应的电表也删除
        meterMapper.deleteByUserId(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getById(Integer userId) {
        return userMapper.getById(userId);
    }

    /**
     * 查询前五名欠费最多的童虎
     * @return
     */
    @Override
    public List<User> getArrearsList() {
        return userMapper.getArrearsList();
    }
}
