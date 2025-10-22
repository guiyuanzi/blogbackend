package com.guan.blogbackend.service;

import com.guan.blogbackend.entity.BlogCategory;

import java.util.List;
import java.util.Optional;

/**
 * 分类服务接口
 */
public interface BlogCategoryService {
    
    /**
     * 根据ID查询分类
     * @param id 分类ID
     * @return 分类信息
     */
    Optional<BlogCategory> findById(Long id);
    
    /**
     * 根据名称查询分类
     * @param name 分类名称
     * @return 分类信息
     */
    Optional<BlogCategory> findByName(String name);
    
    /**
     * 保存分类
     * @param category 分类信息
     * @return 保存后的分类信息
     */
    BlogCategory save(BlogCategory category);
    
    /**
     * 更新分类
     * @param category 分类信息
     * @return 更新后的分类信息
     */
    BlogCategory update(BlogCategory category);
    
    /**
     * 删除分类
     * @param id 分类ID
     */
    void deleteById(Long id);
    
    /**
     * 查询所有分类
     * @return 分类列表
     */
    List<BlogCategory> findAll();
    
    /**
     * 根据排序字段升序查询所有分类
     * @return 分类列表
     */
    List<BlogCategory> findAllByOrderBySortOrderAsc();
    
    /**
     * 判断分类名称是否存在
     * @param name 分类名称
     * @return 是否存在
     */
    boolean existsByName(String name);
}
