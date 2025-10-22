package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
public class ArticleRequestDTO {
    private Long id; // 更新时必传，创建时不传

    @NotBlank(message = "文章标题不能为空")
    private String title;

    @NotBlank(message = "文章内容不能为空")
    private String content;

    private String summary; // 摘要可为空
    private String coverImage; // 封面图URL可为空

    @NotBlank(message = "分类ID不能为空")
    private Long categoryId; // 关联分类ID

    private List<String> tagNames; // 标签名称列表（如["Java", "Spring"]）
    private Integer isTop = 0; // 是否置顶：0-否，1-是（默认否）
}