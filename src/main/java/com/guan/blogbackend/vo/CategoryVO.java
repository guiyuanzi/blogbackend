package com.guan.blogbackend.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoryVO {
    private Long id;                  // 分类ID
    private String name;              // 分类名称
    private Integer sortOrder;        // 排序序号（用于前端排序展示）
    private LocalDateTime createTime; // 创建时间
    private Long articleCount;        // 该分类下的文章数量（扩展字段，方便前端展示）
}