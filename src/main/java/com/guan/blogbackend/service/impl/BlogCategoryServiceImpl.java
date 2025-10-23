package com.guan.blogbackend.service.impl;

import com.guan.blogbackend.entity.BlogCategory;
import com.guan.blogbackend.repository.BlogCategoryRepository;
import com.guan.blogbackend.service.BlogCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogCategoryServiceImpl implements BlogCategoryService {

    private final BlogCategoryRepository categoryRepository;

    @Override
    public Optional<BlogCategory> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<BlogCategory> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    @Transactional
    public BlogCategory save(BlogCategory category) {
        if (existsByName(category.getName())) {
            throw new RuntimeException("分类名称已存在");
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public BlogCategory update(BlogCategory category) {
        // 检查是否重名（排除当前ID）
        Optional<BlogCategory> existing = categoryRepository.findByName(category.getName());
        if (existing.isPresent() && !existing.get().getId().equals(category.getId())) {
            throw new RuntimeException("分类名称已存在");
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<BlogCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<BlogCategory> findAllByOrderBySortOrderAsc() {
        return categoryRepository.findAllByOrderBySortOrderAsc();
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }
}