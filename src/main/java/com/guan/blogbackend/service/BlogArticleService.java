package com.guan.blogbackend.service;

import com.guan.blogbackend.entity.BlogArticle;
import com.guan.blogbackend.entity.BlogCategory;
import com.guan.blogbackend.entity.SysUser;

import java.util.List;
import java.util.Optional;

/**
 * 文章服务接口
 */
public interface BlogArticleService {
    
    /**
     * 根据ID查询文章
     * @param id 文章ID
     * @return 文章信息
     */
    Optional<BlogArticle> findById(Long id);
    
    /**
     * 根据作者查询文章
     * @param author 作者
     * @return 文章列表
     */
    List<BlogArticle> findByAuthor(SysUser author);
    
    /**
     * 根据分类查询文章
     * @param category 分类
     * @return 文章列表
     */
    List<BlogArticle> findByCategory(BlogCategory category);
    
    /**
     * 根据发布状态查询文章
     * @param isPublished 发布状态：0-草稿，1-已发布
     * @return 文章列表
     */
    List<BlogArticle> findByIsPublished(Integer isPublished);
    
    /**
     * 根据置顶状态查询文章
     * @param isTop 置顶状态：0-否，1-是
     * @return 文章列表
     */
    List<BlogArticle> findByIsTop(Integer isTop);
    
    /**
     * 根据标题模糊查询文章
     * @param title 标题关键词
     * @return 文章列表
     */
    List<BlogArticle> findByTitleContaining(String title);
    
    /**
     * 保存文章
     * @param article 文章信息
     * @return 保存后的文章信息
     */
    BlogArticle save(BlogArticle article);
    
    /**
     * 更新文章
     * @param article 文章信息
     * @return 更新后的文章信息
     */
    BlogArticle update(BlogArticle article);
    
    /**
     * 删除文章
     * @param id 文章ID
     */
    void deleteById(Long id);
    
    /**
     * 查询所有文章
     * @return 文章列表
     */
    List<BlogArticle> findAll();
    
    /**
     * 根据发布状态和分类查询文章
     * @param isPublished 发布状态
     * @param category 分类
     * @return 文章列表
     */
    List<BlogArticle> findByIsPublishedAndCategory(Integer isPublished, BlogCategory category);
    
    /**
     * 查询最新发布的文章
     * @param limit 数量限制
     * @return 文章列表
     */
    List<BlogArticle> findLatestPublishedArticles(int limit);
    
    /**
     * 统计用户发布的文章数量
     * @param author 作者
     * @return 文章数量
     */
    long countByAuthorAndIsPublished(SysUser author);
    
    /**
     * 增加文章阅读量
     * @param id 文章ID
     */
    void increaseViewCount(Long id);
    
    /**
     * 发布文章
     * @param id 文章ID
     * @return 发布后的文章
     */
    BlogArticle publishArticle(Long id);
    
    /**
     * 置顶文章
     * @param id 文章ID
     * @param isTop 是否置顶：0-否，1-是
     * @return 更新后的文章
     */
    BlogArticle setTop(Long id, Integer isTop);
}