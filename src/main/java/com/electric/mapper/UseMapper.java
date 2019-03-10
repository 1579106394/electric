package com.electric.mapper;

import com.electric.domain.Page;
import com.electric.domain.Use;

import java.util.List;

public interface UseMapper {

    /**
     * 新增用电记录
     * @param use
     */
    void addUse(Use use);

    /**
     * 查询用电记录
     * @param p
     * @return
     */
    List<Use> getListByPage(Page<Use> p);

    /**
     * 查询数量
     * @param p
     * @return
     */
    int getCountByPage(Page<Use> p);

    /**
     * 根据id删除
     * @param useId
     */
    void deleteById(Integer useId);

    /**
     * 根据id查询用电记录
     * @param userId
     * @return
     */
    List<Use> getByUserId(Integer userId);
}
