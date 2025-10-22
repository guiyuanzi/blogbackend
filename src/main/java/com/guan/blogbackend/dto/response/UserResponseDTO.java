package com.guan.blogbackend.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String avatar;
    private Integer userRole; // 0-普通用户，1-管理员
    private Integer status; // 0-禁用，1-正常
    private LocalDateTime createTime; // 注册时间
}