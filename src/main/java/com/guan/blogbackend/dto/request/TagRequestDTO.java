package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TagRequestDTO {
    private Long id; // 更新时必传
    @NotBlank(message = "标签名称不能为空")
    private String name;
}