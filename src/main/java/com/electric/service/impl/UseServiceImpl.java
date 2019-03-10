package com.electric.service.impl;

import com.electric.domain.Page;
import com.electric.domain.Use;
import com.electric.mapper.UseMapper;
import com.electric.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UseServiceImpl implements UseService {

    @Autowired
    private UseMapper useMapper;

    /**
     * 新增用电记录
     * @param use
     */
    @Override
    public void addUse(Use use) {
        useMapper.addUse(use);
    }

    /**
     * 分页查询用电记录
     * @param p
     * @return
     */
    @Override
    public Page<Use> getByPage(Page<Use> p) {
        // 当前页如果为空，则设置为1
        if (p.getCurrentPage() == null) {
            p.setCurrentPage(1);
        }
        // 设置每页显示条数为15，每页索引在这个set方法里自动封装
        p.setCurrentCount(15);
        // 根据page分页查询数据列表
        List<Use> list = useMapper.getListByPage(p);
        // 数据放到p中
        p.setList(list);
        // 查询总条数
        int count = useMapper.getCountByPage(p);
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
     * @param useId
     */
    @Override
    public void deleteById(Integer useId) {
        useMapper.deleteById(useId);
    }

    /**
     * 查询用户6个月的用电记录
     * @param userId
     * @return
     */
    @Override
    public List<Use> getByUserId(Integer userId) {
        return useMapper.getByUserId(userId);
    }
}
