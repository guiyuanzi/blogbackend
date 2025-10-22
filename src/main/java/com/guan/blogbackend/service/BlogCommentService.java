package com.guan.blogbackend.service;

import com.guan.blogbackend.entity.BlogArticle;
import com.guan.blogbackend.entity.BlogComment;
import com.guan.blogbackend.entity.SysUser;

import java.util.List;
import java.util.Optional;

/**
 * 评论服务接口
 */
public interface BlogCommentService {
    
    /**
     * 根据ID查询评论
     * @param id 评论ID
     * @return 评论信息
     */
    Optional<BlogComment> findById(Long id);
    
    /**
     * 根据文章查询评论
     * @param article 文章
     * @return 评论列表
     */
    List<BlogComment> findByArticle(BlogArticle article);
    
    /**
     * 根据用户查询评论
     * @param user 用户
     * @return 评论列表
     */
    List<BlogComment> findByUser(SysUser user);
    
    /**
     * 根据父评论查询子评论
     * @param parent 父评论
     * @return 子评论列表
     */
    List<BlogComment> findByParent(BlogComment parent);
    
    /**
     * 根据状态查询评论
     * @param status 状态：0-待审核，1-通过，2-驳回
     * @return 评论列表
     */
    List<BlogComment> findByStatus(Integer status);
    
    /**
     * 根据文章和状态查询评论
     * @param article 文章
     * @param status 状态
     * @return 评论列表
     */
    List<BlogComment> findByArticleAndStatus(BlogArticle article, Integer status);
    
    /**
     * 保存评论
     * @param comment 评论信息
     * @return 保存后的评论信息
     */
    BlogComment save(BlogComment comment);
    
    /**
     * 更新评论
     * @param comment 评论信息
     * @return 更新后的评论信息
     */
    BlogComment update(BlogComment comment);
    
    /**
     * 删除评论
     * @param id 评论ID
     */
    void deleteById(Long id);
    
    /**
     * 查询所有评论
     * @return 评论列表
     */
    List<BlogComment> findAll();
    
    /**
     * 统计文章的评论数量
     * @param article 文章
     * @param status 状态
     * @return 评论数量
     */
    long countByArticleAndStatus(BlogArticle article, Integer status);
    
    /**
     * 审核评论
     * @param id 评论ID
     * @param status 审核状态：1-通过，2-驳回
     * @return 审核后的评论
     */
    BlogComment auditComment(Long id, Integer status);
    
    /**
     * 发表评论
     * @param article 文章
     * @param user 用户（可为空，表示匿名评论）
     * @param parent 父评论（可为空，表示一级评论）
     * @param content 评论内容
     * @param nickname 匿名评论昵称（user为空时必填）
     * @param email 匿名评论邮箱（user为空时必填）
     * @return 发表后的评论
     */
    BlogComment addComment(BlogArticle article, SysUser user, BlogComment parent, 
                         String content, String nickname, String email);
}
