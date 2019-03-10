package com.electric.mapper;

import com.electric.domain.Comment;
import com.electric.domain.Page;

import java.util.List;

public interface CommentMapper {

    /**
     * 新增反馈
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 分页查询
     * @param p
     * @return
     */
    List<Comment> getListByPage(Page<Comment> p);

    /**
     * 查询数量
     * @param p
     * @return
     */
    int getCountByPage(Page<Comment> p);

    /**
     * 根据id删除
     * @param commentId
     */
    void deleteById(Integer commentId);

    /**
     * 根据id查询
     * @param commentId
     * @return
     */
    Comment getById(Integer commentId);
}
