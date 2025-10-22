package com.guan.blogbackend.controller;

import com.guan.blogbackend.dto.request.CommentAuditRequestDTO;
import com.guan.blogbackend.dto.request.CommentRequestDTO;
import com.guan.blogbackend.dto.response.CommentResponseDTO;
import com.guan.blogbackend.service.BlogCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final BlogCommentService commentService;

    /**
     * 发表评论
     */
    @PostMapping
    public ResponseEntity<CommentResponseDTO> addComment(@Valid @RequestBody CommentRequestDTO request) {
        // 业务逻辑：调用addComment()方法保存评论
        return ResponseEntity.ok(null);
    }

    /**
     * 审核评论（管理员接口）
     */
    @PutMapping("/audit")
    public ResponseEntity<CommentResponseDTO> auditComment(@Valid @RequestBody CommentAuditRequestDTO request) {
        // 业务逻辑：调用auditComment()更新状态
        return ResponseEntity.ok(null);
    }

    /**
     * 删除评论
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 根据文章ID查询评论列表
     */
    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByArticle(
            @PathVariable Long articleId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        // 业务逻辑：查询文章下的评论（支持分页、嵌套子评论）
        return ResponseEntity.ok(null);
    }

    /**
     * 获取评论总数（按文章ID）
     */
    @GetMapping("/count/article/{articleId}")
    public ResponseEntity<Long> getCommentCountByArticle(@PathVariable Long articleId) {
        // 业务逻辑：统计文章的有效评论数
        return ResponseEntity.ok(0L);
    }
}