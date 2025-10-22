package com.guan.blogbackend.controller;

import com.guan.blogbackend.dto.request.CategoryRequestDTO;
import com.guan.blogbackend.dto.response.CategoryResponseDTO;
import com.guan.blogbackend.service.BlogCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final BlogCategoryService categoryService;

    /**
     * 创建分类
     */
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@Valid @RequestBody CategoryRequestDTO request) {
        // 业务逻辑：保存分类
        return ResponseEntity.ok(null);
    }

    /**
     * 更新分类
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDTO request) {
        // 业务逻辑：更新分类
        return ResponseEntity.ok(null);
    }

    /**
     * 删除分类
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 查询所有分类（按排序升序）
     */
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        // 业务逻辑：调用findAllByOrderBySortOrderAsc()
        return ResponseEntity.ok(null);
    }

    /**
     * 根据ID查询分类
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        // 业务逻辑：查询单个分类
        return ResponseEntity.ok(null);
    }
}