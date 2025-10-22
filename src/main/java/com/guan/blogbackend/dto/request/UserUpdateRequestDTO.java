package com.guan.blogbackend.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserUpdateRequestDTO {
    private Long id; // 必传，用于定位用户
    private String nickname;
    @Email(message = "邮箱格式不正确")
    private String email;
    private String avatar; // 头像URL
}