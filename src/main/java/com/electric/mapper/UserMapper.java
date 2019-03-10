package com.electric.mapper;

import com.electric.domain.Page;
import com.electric.domain.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User getByUsername(String username);

    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);

    /**
     * 分页查询列表
     * @param p
     * @return
     */
    List<User> getListByPage(Page<User> p);

    /**
     * 查询数量
     * @param page
     * @return
     */
    int getCountByPage(Page<User> page);

    /**
     * 根据id删除
     * @param userId
     */
    void deleteById(Integer userId);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    User getById(Integer userId);

    /**
     * 查询前五名欠费最多的用户
     * @return
     */
    List<User> getArrearsList();
}
