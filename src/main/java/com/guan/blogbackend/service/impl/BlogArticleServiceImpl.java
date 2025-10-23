package com.guan.blogbackend.service.impl;

import com.guan.blogbackend.entity.BlogArticle;
import com.guan.blogbackend.entity.BlogCategory;
import com.guan.blogbackend.entity.SysUser;
import com.guan.blogbackend.repository.BlogArticleRepository;
import com.guan.blogbackend.service.BlogArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogArticleServiceImpl implements BlogArticleService {

    private final BlogArticleRepository articleRepository;

    @Override
    public Optional<BlogArticle> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<BlogArticle> findByAuthor(SysUser author) {
        return articleRepository.findByAuthor(author);
    }

    @Override
    public List<BlogArticle> findByCategory(BlogCategory category) {
        return articleRepository.findByCategory(category);
    }

    @Override
    public List<BlogArticle> findByIsPublished(Integer isPublished) {
        return articleRepository.findByIsPublished(isPublished);
    }

    @Override
    public List<BlogArticle> findByIsTop(Integer isTop) {
        return articleRepository.findByIsTop(isTop);
    }

    @Override
    public List<BlogArticle> findByTitleContaining(String title) {
        return articleRepository.findByTitleContaining(title);
    }

    @Override
    @Transactional
    public BlogArticle save(BlogArticle article) {
        return articleRepository.save(article);
    }

    @Override
    @Transactional
    public BlogArticle update(BlogArticle article) {
        return articleRepository.save(article);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<BlogArticle> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public List<BlogArticle> findByIsPublishedAndCategory(Integer isPublished, BlogCategory category) {
        return articleRepository.findByIsPublishedAndCategory(isPublished, category);
    }

    @Override
    public List<BlogArticle> findLatestPublishedArticles(int limit) {
        return articleRepository.findLatestPublishedArticles(1, limit);
    }

    @Override
    public long countByAuthorAndIsPublished(SysUser author) {
        return articleRepository.countByAuthorAndIsPublished(author, 1);
    }

    @Override
    @Transactional
    public void increaseViewCount(Long id) {
        articleRepository.findById(id).ifPresent(article -> {
            article.setViewCount(article.getViewCount() + 1);
            articleRepository.save(article);
        });
    }

    @Override
    @Transactional
    public BlogArticle publishArticle(Long id) {
        BlogArticle article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("文章不存在"));
        article.setIsPublished(1);
        article.setPublishTime(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    @Transactional
    public BlogArticle setTop(Long id, Integer isTop) {
        BlogArticle article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("文章不存在"));
        article.setIsTop(isTop);
        return articleRepository.save(article);
    }
}