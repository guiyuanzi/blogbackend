package com.guan.blogbackend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleListResponseDTO {
    private Long id;
    private String title;
    private String summary;
    private String coverImage;
    private String categoryName; // 分类名称
    private List<String> tagNames; // 标签名称列表
    private Integer viewCount; // 阅读量
    private LocalDateTime publishTime; // 发布时间
    private UserSimpleResponseDTO author; // 作者简信息
}