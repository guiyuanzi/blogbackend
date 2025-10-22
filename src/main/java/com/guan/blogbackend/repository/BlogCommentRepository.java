package com.guan.blogbackend.repository;

import com.guan.blogbackend.entity.BlogArticle;
import com.guan.blogbackend.entity.BlogComment;
import com.guan.blogbackend.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {
    
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
     * 统计文章的评论数量
     * @param article 文章
     * @param status 状态
     * @return 评论数量
     */
    long countByArticleAndStatus(BlogArticle article, Integer status);
}
