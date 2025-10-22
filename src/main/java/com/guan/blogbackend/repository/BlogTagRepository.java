package com.guan.blogbackend.repository;

import com.guan.blogbackend.entity.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogTagRepository extends JpaRepository<BlogTag, Long> {
    
    /**
     * 根据名称查询标签
     * @param name 标签名称
     * @return 标签信息
     */
    Optional<BlogTag> findByName(String name);
    
    /**
     * 判断标签名称是否存在
     * @param name 标签名称
     * @return 是否存在
     */
    boolean existsByName(String name);
    
    /**
     * 根据名称列表查询标签
     * @param names 标签名称列表
     * @return 标签列表
     */
    List<BlogTag> findByNameIn(List<String> names);
}
