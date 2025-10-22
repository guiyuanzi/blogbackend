package com.guan.blogbackend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentResponseDTO {
    private Long id;
    private String content;
    private Integer status;
    private LocalDateTime createTime;
    private Long parentId; // 父评论ID，null表示一级评论

    // 评论者信息（登录用户显示用户名，匿名显示nickname）
    private Long userId; // 非匿名时不为空
    private String username; // 登录用户昵称
    private String nickname; // 匿名用户昵称
    private String avatar; // 登录用户头像

    // 子评论列表（嵌套自身）
    private List<CommentResponseDTO> children;
}