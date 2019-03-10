package com.electric.service;

import com.electric.domain.Comment;
import com.electric.domain.Page;

public interface CommentService {

    /**
     * 新增反馈
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 分页查询用户反馈
     * @param p
     * @return
     */
    Page<Comment> getByPage(Page<Comment> p);

    /**
     * 根据id删除
     * @param commentId
     */
    void deleteById(Integer commentId);

    /**
     * '根据id查询
     * @param commentId
     * @return
     */
    Comment getById(Integer commentId);
}
