package com.guan.blogbackend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleDetailResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String summary;
    private String coverImage;
    private String categoryName;
    private List<String> tagNames;
    private Integer viewCount;
    private Integer isTop;
    private Integer isPublished;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime publishTime;
    private UserSimpleResponseDTO author;
}