package com.guan.blogbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "blog_comment")
public class BlogComment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 多对一关系：多个评论属于一篇文章
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private BlogArticle article;
    
    // 多对一关系：多个评论可以属于一个用户（可为空表示匿名匿名评论）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private SysUser user;
    
    // 自关联：评论的回复
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private BlogComment parent;
    
    @Column(nullable = false, length = 500)
    private String content;
    
    @Column(length = 50)
    private String nickname;
    
    @Column(length = 100)
    private String email;
    
    @Column(nullable = false)
    private Integer status = 1; // 0-待审核，1-通过，2-驳回
    
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    // 自关联：评论的子评论
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogComment> children;
}
