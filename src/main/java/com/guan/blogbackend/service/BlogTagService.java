package com.guan.blogbackend.service;

import com.guan.blogbackend.entity.BlogTag;

import java.util.List;
import java.util.Optional;

/**
 * 标签服务接口
 */
public interface BlogTagService {
    
    /**
     * 根据ID查询标签
     * @param id 标签ID
     * @return 标签信息
     */
    Optional<BlogTag> findById(Long id);
    
    /**
     * 根据名称查询标签
     * @param name 标签名称
     * @return 标签信息
     */
    Optional<BlogTag> findByName(String name);
    
    /**
     * 根据名称列表查询标签
     * @param names 标签名称列表
     * @return 标签列表
     */
    List<BlogTag> findByNameIn(List<String> names);
    
    /**
     * 保存标签
     * @param tag 标签信息
     * @return 保存后的标签信息
     */
    BlogTag save(BlogTag tag);
    
    /**
     * 批量保存标签
     * @param tags 标签列表
     * @return 保存后的标签列表
     */
    List<BlogTag> saveAll(List<BlogTag> tags);
    
    /**
     * 更新标签
     * @param tag 标签信息
     * @return 更新后的标签信息
     */
    BlogTag update(BlogTag tag);
    
    /**
     * 删除标签
     * @param id 标签ID
     */
    void deleteById(Long id);
    
    /**
     * 查询所有标签
     * @return 标签列表
     */
    List<BlogTag> findAll();
    
    /**
     * 判断标签名称是否存在
     * @param name 标签名称
     * @return 是否存在
     */
    boolean existsByName(String name);
    
    /**
     * 根据标签名称创建或获取标签
     * @param name 标签名称
     * @return 标签信息
     */
    BlogTag getOrCreateTag(String name);
    
    /**
     * 批量处理标签（创建不存在的标签）
     * @param tagNames 标签名称列表
     * @return 处理后的标签列表
     */
    List<BlogTag> processTags(List<String> tagNames);
}
