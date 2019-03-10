package com.electric.service.impl;

import com.electric.domain.Comment;
import com.electric.domain.Page;
import com.electric.mapper.CommentMapper;
import com.electric.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 新增反馈
     * @param comment
     */
    @Override
    public void addComment(Comment comment) {
        // 补全属性：反馈时间
        comment.setCommentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        commentMapper.addComment(comment);
    }

    @Override
    public Page<Comment> getByPage(Page<Comment> p) {
        // 当前页如果为空，则设置为1
        if (p.getCurrentPage() == null) {
            p.setCurrentPage(1);
        }
        // 设置每页显示条数为15，每页索引在这个set方法里自动封装
        p.setCurrentCount(15);
        // 根据page分页查询数据列表
        List<Comment> list = commentMapper.getListByPage(p);
        // 数据放到p中
        p.setList(list);
        // 查询总条数
        int count = commentMapper.getCountByPage(p);
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
    public void deleteById(Integer commentId) {
        commentMapper.deleteById(commentId);
    }

    /**
     * 根据id查询
     * @param commentId
     * @return
     */
    @Override
    public Comment getById(Integer commentId) {
        return commentMapper.getById(commentId);
    }
}
