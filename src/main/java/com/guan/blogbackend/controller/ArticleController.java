package com.guan.blogbackend.controller;

import com.guan.blogbackend.dto.request.ArticlePublishRequestDTO;
import com.guan.blogbackend.dto.request.ArticleRequestDTO;
import com.guan.blogbackend.dto.response.ArticleDetailResponseDTO;
import com.guan.blogbackend.dto.response.ArticleListResponseDTO;
import com.guan.blogbackend.service.BlogArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final BlogArticleService articleService;

    /**
     * 创建文章（保存草稿）
     */
    @PostMapping
    public ResponseEntity<ArticleDetailResponseDTO> createArticle(@Valid @RequestBody ArticleRequestDTO request) {
        // 业务逻辑：保存草稿（isPublished=0）
        return ResponseEntity.ok(null);
    }

    /**
     * 更新文章
     */
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDetailResponseDTO> updateArticle(
            @PathVariable Long id,
            @Valid @RequestBody ArticleRequestDTO request) {
        // 业务逻辑：更新文章信息
        return ResponseEntity.ok(null);
    }

    /**
     * 发布文章
     */
    @PostMapping("/publish")
    public ResponseEntity<ArticleDetailResponseDTO> publishArticle(@Valid @RequestBody ArticlePublishRequestDTO request) {
        // 业务逻辑：调用service发布文章（更新isPublished=1）
        return ResponseEntity.ok(null);
    }

    /**
     * 获取文章详情
     */
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDetailResponseDTO> getArticleDetail(@PathVariable Long id) {
        // 业务逻辑：查询文章详情，增加阅读量
        return ResponseEntity.ok(null);
    }

    /**
     * 分页查询文章列表
     */
    @GetMapping
    public ResponseEntity<List<ArticleListResponseDTO>> getArticleList(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        // 业务逻辑：按条件分页查询
        return ResponseEntity.ok(null);
    }

    /**
     * 删除文章
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 置顶/取消置顶文章
     */
    @PutMapping("/{id}/top")
    public ResponseEntity<ArticleDetailResponseDTO> setTop(
            @PathVariable Long id,
            @RequestParam Integer isTop) {
        // 业务逻辑：调用service设置置顶状态
        return ResponseEntity.ok(null);
    }
}