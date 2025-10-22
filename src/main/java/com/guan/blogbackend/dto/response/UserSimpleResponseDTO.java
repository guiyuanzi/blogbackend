package com.guan.blogbackend.dto.response;

import lombok.Data;

@Data
public class UserSimpleResponseDTO {
    private Long id;
    private String username;
    private String nickname;
    private String avatar;
}