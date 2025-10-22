package com.guan.blogbackend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private Integer sortOrder;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}