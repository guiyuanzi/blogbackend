package com.guan.blogbackend.controller;

import com.guan.blogbackend.dto.request.LoginRequestDTO;
import com.guan.blogbackend.dto.request.RegisterRequestDTO;
import com.guan.blogbackend.dto.request.UserUpdateRequestDTO;
import com.guan.blogbackend.dto.response.UserResponseDTO;
import com.guan.blogbackend.service.SysUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final SysUserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        // 业务逻辑：调用service注册用户，转换为响应DTO
        return ResponseEntity.ok(null); // 实际开发中替换为service返回的转换结果
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        // 业务逻辑：调用service登录，返回用户信息（通常包含token）
        return ResponseEntity.ok(null);
    }

    /**
     * 获取当前登录用户信息
     */
    @GetMapping("/current")
    public ResponseEntity<UserResponseDTO> getCurrentUser() {
        // 业务逻辑：从会话/Token中获取当前用户
        return ResponseEntity.ok(null);
    }

    /**
     * 更新用户信息
     */
    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserUpdateRequestDTO request) {
        // 业务逻辑：调用service更新用户
        return ResponseEntity.ok(null);
    }

    /**
     * 根据ID查询用户（管理员接口）
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        // 业务逻辑：查询指定用户
        return ResponseEntity.ok(null);
    }
}