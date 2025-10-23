package com.guan.blogbackend.service.impl;

import com.guan.blogbackend.entity.BlogConfig;
import com.guan.blogbackend.repository.BlogConfigRepository;
import com.guan.blogbackend.service.BlogConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogConfigServiceImpl implements BlogConfigService {

    private final BlogConfigRepository configRepository;

    @Override
    public Optional<BlogConfig> findById(Long id) {
        return configRepository.findById(id);
    }

    @Override
    public Optional<BlogConfig> findByConfigKey(String configKey) {
        return configRepository.findByConfigKey(configKey);
    }

    @Override
    @Transactional
    public BlogConfig save(BlogConfig config) {
        if (existsByConfigKey(config.getConfigKey())) {
            throw new RuntimeException("配置键已存在");
        }
        return configRepository.save(config);
    }

    @Override
    @Transactional
    public List<BlogConfig> saveAll(List<BlogConfig> configs) {
        return configRepository.saveAll(configs);
    }

    @Override
    @Transactional
    public BlogConfig update(BlogConfig config) {
        // 检查配置键是否存在（且属于当前记录）
        Optional<BlogConfig> existing = configRepository.findByConfigKey(config.getConfigKey());
        if (existing.isPresent() && !existing.get().getId().equals(config.getId())) {
            throw new RuntimeException("配置键已存在");
        }
        return configRepository.save(config);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        configRepository.deleteById(id);
    }

    @Override
    public List<BlogConfig> findAll() {
        return configRepository.findAll();
    }

    @Override
    public boolean existsByConfigKey(String configKey) {
        return configRepository.existsByConfigKey(configKey);
    }

    @Override
    public String getConfigValue(String configKey) {
        return configRepository.findByConfigKey(configKey)
                .map(BlogConfig::getConfigValue)
                .orElse(null);
    }

    @Override
    public String getConfigValue(String configKey, String defaultValue) {
        return configRepository.findByConfigKey(configKey)
                .map(BlogConfig::getConfigValue)
                .orElse(defaultValue);
    }

    @Override
    public Map<String, String> getAllConfigMap() {
        List<BlogConfig> configs = configRepository.findAll();
        Map<String, String> configMap = new HashMap<>();
        for (BlogConfig config : configs) {
            configMap.put(config.getConfigKey(), config.getConfigValue());
        }
        return configMap;
    }

    @Override
    @Transactional
    public BlogConfig updateOrSaveConfig(String configKey, String configValue) {
        BlogConfig config = configRepository.findByConfigKey(configKey)
                .orElse(new BlogConfig());
        config.setConfigKey(configKey);
        config.setConfigValue(configValue);
        return configRepository.save(config);
    }
}