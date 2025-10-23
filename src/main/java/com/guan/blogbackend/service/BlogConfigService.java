package com.guan.blogbackend.service;

import com.guan.blogbackend.entity.BlogConfig;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 配置服务接口
 */
public interface BlogConfigService {
    
    /**
     * 根据ID查询配置
     * @param id 配置ID
     * @return 配置信息
     */
    Optional<BlogConfig> findById(Long id);
    
    /**
     * 根据配置键查询配置
     * @param configKey 配置键
     * @return 配置信息
     */
    Optional<BlogConfig> findByConfigKey(String configKey);
    
    /**
     * 保存配置
     * @param config 配置信息
     * @return 保存后的配置信息
     */
    BlogConfig save(BlogConfig config);
    
    /**
     * 批量保存配置
     * @param configs 配置列表
     * @return 保存后的配置列表
     */
    List<BlogConfig> saveAll(List<BlogConfig> configs);
    
    /**
     * 更新配置
     * @param config 配置信息
     * @return 更新后的配置信息
     */
    BlogConfig update(BlogConfig config);
    
    /**
     * 删除配置
     * @param id 配置ID
     */
    void deleteById(Long id);
    
    /**
     * 查询所有配置
     * @return 配置列表
     */
    List<BlogConfig> findAll();
    
    /**
     * 判断配置键是否存在
     * @param configKey 配置键
     * @return 是否存在
     */
    boolean existsByConfigKey(String configKey);
    
    /**
     * 获取配置值
     * @param configKey 配置键
     * @return 配置值
     */
    String getConfigValue(String configKey);
    
    /**
     * 获取配置值（带默认值）
     * @param configKey 配置键
     * @param defaultValue 默认值
     * @return 配置值（如果不存在则返回默认值）
     */
    String getConfigValue(String configKey, String defaultValue);
    
    /**
     * 获取所有配置的键值对
     * @return 配置键值对
     */
    Map<String, String> getAllConfigMap();
    
    /**
     * 更新或保存配置
     * @param configKey 配置键
     * @param configValue 配置值
     * @return 更新后的配置信息
     */
    BlogConfig updateOrSaveConfig(String configKey, String configValue);
}