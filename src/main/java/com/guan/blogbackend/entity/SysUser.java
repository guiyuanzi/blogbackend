package com.guan.blogbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "sys_user")
public class SysUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    
    @Column(nullable = false, length = 100)
    private String password;
    
    @Column(length = 50)
    private String nickname;
    
    @Column(unique = true, length = 100)
    private String email;
    
    @Column(length = 255)
    private String avatar;
    
    @Column(nullable = false)
    private Integer status = 1; // 0-禁用，1-正常
    
    @Column(name = "user_role", nullable = false)
    private Integer userRole = 0; // 0-普通用户，1-管理员
    
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;
    
    // 一对多关系：一个用户可以发布多篇文章
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogArticle> articles;
    
    // 一对多关系：一个用户可以发表多条评论
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogComment> comments;
}
