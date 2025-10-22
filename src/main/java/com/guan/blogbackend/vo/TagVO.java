package com.guan.blogbackend.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TagVO {
    private Long id;                  // 标签ID
    private String name;              // 标签名称
    private LocalDateTime createTime; // 创建时间
    private Long articleCount;        // 该标签关联的文章数量（扩展字段）
}