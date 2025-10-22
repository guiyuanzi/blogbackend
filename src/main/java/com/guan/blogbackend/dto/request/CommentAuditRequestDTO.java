package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentAuditRequestDTO {
    @NotNull(message = "评论ID不能为空")
    private Long id;

    @NotNull(message = "审核状态不能为空")
    private Integer status; // 1-通过，2-驳回
}