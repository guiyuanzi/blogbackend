package com.guan.blogbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 配置密码加密器（必须添加，否则Spring Security无法找到该Bean）
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 使用BCrypt加密算法
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 放行Swagger相关接口
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**"
                        ).permitAll()
                        // 放行登录、注册接口（根据实际接口路径调整）
                        .requestMatchers("/api/auth/login", "/api/auth/register").permitAll()
                        // 其他接口需要认证
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()); // 开发环境关闭CSRF

        return http.build();
    }
}