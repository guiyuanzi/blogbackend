package com.guan.blogbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Entity
@Table(name = "blog_config")
public class BlogConfig {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "config_key", nullable = false, unique = true, length = 100)
    private String configKey;
    
    @Column(name = "config_value", columnDefinition = "text")
    private String configValue;

    @Configuration
    public class SecurityConfig {
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
}
