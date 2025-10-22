package com.guan.blogbackend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TagResponseDTO {
    private Long id;
    private String name;
    private LocalDateTime createTime;
}