package com.guan.blogbackend.vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleDetailVO extends ArticleListVO {
    private String content;           // 文章正文（列表不展示，详情展示）
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    private Integer isPublished;      // 发布状态（用于作者查看自己的文章状态）
}