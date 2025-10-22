package com.guan.blogbackend.repository;

import com.guan.blogbackend.entity.BlogConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogConfigRepository extends JpaRepository<BlogConfig, Long> {
    
    /**
     * 根据配置键查询配置值
     * @param configKey 配置键
     * @return 配置信息
     */
    Optional<BlogConfig> findByConfigKey(String configKey);
    
    /**
     * 判断配置键是否配置是否存在
     * @param configKey 配置键
     * @return 是否存在
     */
    boolean existsByConfigKey(String configKey);
}
