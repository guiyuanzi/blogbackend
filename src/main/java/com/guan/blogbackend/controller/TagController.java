package com.guan.blogbackend.controller;

import com.guan.blogbackend.dto.request.TagRequestDTO;
import com.guan.blogbackend.dto.response.TagResponseDTO;
import com.guan.blogbackend.service.BlogTagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final BlogTagService tagService;

    /**
     * 创建标签
     */
    @PostMapping
    public ResponseEntity<TagResponseDTO> createTag(@Valid @RequestBody TagRequestDTO request) {
        // 业务逻辑：保存标签
        return ResponseEntity.ok(null);
    }

    /**
     * 更新标签
     */
    @PutMapping("/{id}")
    public ResponseEntity<TagResponseDTO> updateTag(
            @PathVariable Long id,
            @Valid @RequestBody TagRequestDTO request) {
        // 业务逻辑：更新标签
        return ResponseEntity.ok(null);
    }

    /**
     * 删除标签
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 查询所有标签
     */
    @GetMapping
    public ResponseEntity<List<TagResponseDTO>> getAllTags() {
        // 业务逻辑：查询所有标签
        return ResponseEntity.ok(null);
    }

    /**
     * 根据名称查询标签（用于前端校验）
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Boolean> existsByName(@PathVariable String name) {
        return ResponseEntity.ok(tagService.existsByName(name));
    }
}