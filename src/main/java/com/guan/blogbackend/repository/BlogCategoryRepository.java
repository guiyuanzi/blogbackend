package com.guan.blogbackend.repository;

import com.guan.blogbackend.entity.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {
    
    /**
     * 根据名称查询分类
     * @param name 分类名称
     * @return 分类信息
     */
    Optional<BlogCategory> findByName(String name);
    
    /**
     * 判断分类名称是否存在
     * @param name 分类名称
     * @return 是否存在
     */
    boolean existsByName(String name);
    
    /**
     * 根据排序字段升序分类
     * @return 分类列表
     */
    List<BlogCategory> findAllByOrderBySortOrderAsc();
}
