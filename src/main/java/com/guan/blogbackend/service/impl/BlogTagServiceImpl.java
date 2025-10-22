package com.guan.blogbackend.service.impl;

import com.guan.blogbackend.entity.BlogTag;
import com.guan.blogbackend.repository.BlogTagRepository;
import com.guan.blogbackend.service.BlogTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogTagServiceImpl implements BlogTagService {

    private final BlogTagRepository tagRepository;

    @Override
    public Optional<BlogTag> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Optional<BlogTag> findByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public List<BlogTag> findByNameIn(List<String> names) {
        return tagRepository.findByNameIn(names);
    }

    @Override
    @Transactional
    public BlogTag save(BlogTag tag) {
        if (existsByName(tag.getName())) {
            throw new RuntimeException("标签已存在");
        }
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public List<BlogTag> saveAll(List<BlogTag> tags) {
        return tagRepository.saveAll(tags);
    }

    @Override
    @Transactional
    public BlogTag update(BlogTag tag) {
        // 检查是否重名（排除当前ID）
        Optional<BlogTag> existing = tagRepository.findByName(tag.getName());
        if (existing.isPresent() && !existing.get().getId().equals(tag.getId())) {
            throw new RuntimeException("标签已存在");
        }
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<BlogTag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return tagRepository.existsByName(name);
    }

    @Override
    @Transactional
    public BlogTag getOrCreateTag(String name) {
        return tagRepository.findByName(name)
                .orElseGet(() -> {
                    BlogTag tag = new BlogTag();
                    tag.setName(name);
                    return tagRepository.save(tag);
                });
    }

    @Override
    @Transactional
    public List<BlogTag> processTags(List<String> tagNames) {
        return tagNames.stream()
                .map(this::getOrCreateTag)
                .collect(Collectors.toList());
    }
}