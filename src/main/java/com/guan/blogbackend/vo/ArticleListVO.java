package com.guan.blogbackend.vo;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArticleListVO {
    private Long id;                  // 文章ID
    private String title;             // 标题
    private String summary;           // 摘要
    private String coverImage;        // 封面图
    private String categoryName;      // 分类名称（直接展示名称，无需完整分类信息）
    private List<String> tagNames;    // 标签名称列表
    private Integer viewCount;        // 阅读量
    private Integer isTop;            // 是否置顶
    private LocalDateTime publishTime;// 发布时间
    private UserVO author;            // 作者信息（嵌套UserVO）
}