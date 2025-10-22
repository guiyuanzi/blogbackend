package com.guan.blogbackend.service.impl;

import com.guan.blogbackend.entity.BlogArticle;
import com.guan.blogbackend.entity.BlogComment;
import com.guan.blogbackend.entity.SysUser;
import com.guan.blogbackend.repository.BlogCommentRepository;
import com.guan.blogbackend.service.BlogCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogCommentServiceImpl implements BlogCommentService {

    private final BlogCommentRepository commentRepository;

    @Override
    public Optional<BlogComment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<BlogComment> findByArticle(BlogArticle article) {
        return commentRepository.findByArticle(article);
    }

    @Override
    public List<BlogComment> findByUser(SysUser user) {
        return commentRepository.findByUser(user);
    }

    @Override
    public List<BlogComment> findByParent(BlogComment parent) {
        return commentRepository.findByParent(parent);
    }

    @Override
    public List<BlogComment> findByStatus(Integer status) {
        return commentRepository.findByStatus(status);
    }

    @Override
    public List<BlogComment> findByArticleAndStatus(BlogArticle article, Integer status) {
        return commentRepository.findByArticleAndStatus(article, status);
    }

    @Override
    @Transactional
    public BlogComment save(BlogComment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public BlogComment update(BlogComment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<BlogComment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public long countByArticleAndStatus(BlogArticle article, Integer status) {
        return commentRepository.countByArticleAndStatus(article, status);
    }

    @Override
    @Transactional
    public BlogComment auditComment(Long id, Integer status) {
        BlogComment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("评论不存在"));
        comment.setStatus(status);
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public BlogComment addComment(BlogArticle article, SysUser user, BlogComment parent,
                                  String content, String nickname, String email) {
        // 验证参数
        if (user == null && (nickname == null || email == null)) {
            throw new RuntimeException("匿名评论必须提供昵称和邮箱");
        }

        BlogComment comment = new BlogComment();
        comment.setArticle(article);
        comment.setUser(user);
        comment.setParent(parent);
        comment.setContent(content);
        comment.setNickname(user != null ? user.getNickname() : nickname);
        comment.setEmail(user != null ? user.getEmail() : email);
        comment.setStatus(1); // 默认通过审核

        return commentRepository.save(comment);
    }
}