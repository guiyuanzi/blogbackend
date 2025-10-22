package com.guan.blogbackend.repository;

import com.guan.blogbackend.entity.BlogArticle;
import com.guan.blogbackend.entity.BlogCategory;
import com.guan.blogbackend.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogArticleRepository extends JpaRepository<BlogArticle, Long> {
    
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
     * 根据发布状态和分类查询文章
     * @param isPublished 发布状态
     * @param category 分类
     * @return 文章列表
     */
    List<BlogArticle> findByIsPublishedAndCategory(Integer isPublished, BlogCategory category);
    
    /**
     * 查询最新发布的文章
     * @param isPublished 发布状态
     * @param limit 数量限制
     * @return 文章列表
     */
    @Query("SELECT a FROM BlogArticle a WHERE a.isPublished = :isPublished ORDER BY a.publishTime DESC")
    List<BlogArticle> findLatestPublishedArticles(@Param("isPublished") Integer isPublished, @Param("limit") int limit);
    
    /**
     * 统计用户发布的文章数量
     * @param author 作者
     * @param isPublished 发布状态
     * @return 文章数量
     */
    long countByAuthorAndIsPublished(SysUser author, Integer isPublished);
}
