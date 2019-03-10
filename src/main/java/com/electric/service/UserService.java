package com.electric.service;

import com.electric.domain.Page;
import com.electric.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 根据用户名查询用户
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
     * 根据page分页查询
     * @param p
     * @return
     */
    Page<User> getByPage(Page<User> p);

    /**
     * 根据id删除
     */
    void deleteById(Integer userId);

    /**
     * 修改用户
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
     * 查询前五条欠费最多的用户
     * @return
     */
    List<User> getArrearsList();
}
