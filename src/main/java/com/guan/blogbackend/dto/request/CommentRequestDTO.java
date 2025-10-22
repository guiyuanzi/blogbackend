package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequestDTO {
    @NotNull(message = "文章ID不能为空")
    private Long articleId;

    private Long parentId; // 父评论ID，一级评论可为空

    @NotBlank(message = "评论内容不能为空")
    private String content;

    // 匿名评论时必填（用户未登录）
    private String nickname;
    private String email;
}