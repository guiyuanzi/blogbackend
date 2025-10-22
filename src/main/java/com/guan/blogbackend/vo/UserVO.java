package com.guan.blogbackend.vo;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserVO {
    private Long id;                  // 用户ID
    private String username;          // 用户名（可用于展示）
    private String nickname;          // 昵称（优先展示）
    private String email;             // 邮箱（可选，脱敏显示）
    private String avatar;            // 头像URL
    private Integer userRole;         // 角色（0-普通用户，1-管理员）
    private LocalDateTime createTime; // 注册时间
}