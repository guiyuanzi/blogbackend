package com.guan.blogbackend.vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentVO {
    private Long id;                  // 评论ID
    private String content;           // 评论内容
    private LocalDateTime createTime; // 评论时间
    private UserVO user;              // 评论用户（匿名评论时为null）
    private String nickname;          // 匿名评论的昵称（user为null时展示）
    private Long articleId;           // 所属文章ID
    private Long parentId;            // 父评论ID（顶级评论为null）
    private List<CommentVO> children; // 子评论列表（嵌套自身）
}