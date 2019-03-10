package com.electric.domain;

import java.io.Serializable;

/**
 * 用户反馈表
 * CREATE TABLE `comment` (
 *   `comment_id` int(11) NOT NULL,
 *   `comment_user` int(11) DEFAULT NULL,
 *   `comment_time` varchar(30) DEFAULT NULL,
 *   `comment_content` mediumtext,
 *   PRIMARY KEY (`comment_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Comment implements Serializable {

    private Integer commentId;
    private User user;
    private String commentTime;
    private String commentContent;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
