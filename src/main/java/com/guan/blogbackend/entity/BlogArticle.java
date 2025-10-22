package com.guan.blogbackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "blog_article")
public class BlogArticle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 200)
    private String title;
    
    @Column(nullable = false, columnDefinition = "longtext")
    private String content;
    
    @Column(length = 500)
    private String summary;
    
    @Column(name = "cover_image", length = 255)
    private String coverImage;
    
    // 多对一关系：多篇文章属于一个分类
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private BlogCategory category;
    
    // 多对一关系：多篇文章属于一个作者
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private SysUser author;
    
    @Column(name = "view_count", nullable = false)
    private Integer viewCount = 0;
    
    @Column(name = "is_published", nullable = false)
    private Integer isPublished = 0; // 0-草稿，1-已发布
    
    @Column(name = "is_top", nullable = false)
    private Integer isTop = 0; // 0-否，1-是
    
    @Column(name = "publish_time")
    private LocalDateTime publishTime;
    
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;
    
    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;
    
    // 一对多关系：一篇文章可以有多个评论
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogComment> comments;
    
    // 多对多关系：一篇文章可以有多个标签
    @ManyToMany
    @JoinTable(
        name = "blog_article_tag",
        joinColumns = @JoinColumn(name = "article_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<BlogTag> tags;
}
