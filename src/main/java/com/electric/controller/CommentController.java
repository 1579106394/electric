package com.electric.controller;

import com.electric.domain.Comment;
import com.electric.domain.Page;
import com.electric.domain.User;
import com.electric.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 用户进行反馈
     * @param comment
     * @param session
     * @return
     */
    @RequestMapping("addComment.action")
    public String addComment(Comment comment, HttpSession session) {
        // 获取登录中的用户
        User user = (User) session.getAttribute("user");
        comment.setUser(user);
        commentService.addComment(comment);
        return "redirect:/index.action";
    }

    /**
     * 反馈列表
     */
    @RequestMapping("commentList.action")
    public String commentList(Page<Comment> p, Model model) {
        Page<Comment> page = commentService.getByPage(p);
        model.addAttribute("page", page);
        return "comment/comment-list";
    }

    /**
     * 根据id删除
     * @param commentId
     * @return
     */
    @RequestMapping("deleteComment.action")
    public String deleteComment(Integer commentId) {
        commentService.deleteById(commentId);
        return "redirect:/comment/commentList.action";
    }

    /**
     * 根据id查询，返回json数据
     */
    @RequestMapping("lookComment.action")
    @ResponseBody
    public Comment lookContent(Integer commentId) {
        Comment comment = commentService.getById(commentId);
        return comment;
    }

}
