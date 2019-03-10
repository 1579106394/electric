package com.electric.service;

import com.electric.domain.Page;
import com.electric.domain.Use;

import java.util.List;

public interface UseService {

    /**
     * 新增用电记录
     * @param use
     */
    void addUse(Use use);

    /**
     * 分页查询用电记录
     * @param p
     * @return
     */
    Page<Use> getByPage(Page<Use> p);

    /**
     * 根据id删除
     * @param useId
     */
    void deleteById(Integer useId);

    /**
     * 查询用户6个月的用电记录
     * @param userId
     * @return
     */
    List<Use> getByUserId(Integer userId);
}
