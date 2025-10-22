package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    private Long id; // 更新时必传
    @NotBlank(message = "分类名称不能为空")
    private String name;
    private Integer sortOrder = 0; // 排序优先级，默认0
}