package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ArticlePublishRequestDTO {
    @NotNull(message = "文章ID不能为空")
    private Long id;
}