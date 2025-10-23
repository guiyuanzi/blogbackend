package com.guan.blogbackend.service;

import com.guan.blogbackend.entity.SysUser;

import java.util.List;
import java.util.Optional;

/**
 * 用户服务接口
 */
public interface SysUserService {
    
    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户信息
     */
    Optional<SysUser> findById(Long id);
    
    /**
     * 根据用户名名称查询用户
     * @param username 用户名
     * @return 用户信息
     */
    Optional<SysUser> findByUsername(String username);
    
    /**
     * 根据邮箱查询用户
     * @param email 邮箱
     * @return 用户信息
     */
    Optional<SysUser> findByEmail(String email);
    
    /**
     * 保存用户
     * @param sysUser 用户信息
     * @return 保存后的用户信息
     */
    SysUser save(SysUser sysUser);
    
    /**
     * 更新用户
     * @param sysUser 用户信息
     * @return 更新后的用户信息
     */
    SysUser update(SysUser sysUser);
    
    /**
     * 删除用户
     * @param id 用户ID
     */
    void deleteById(Long id);
    
    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<SysUser> findAll();
    
    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return 是否存在
     */
    boolean existsByUsername(String username);
    
    /**
     * 检查邮箱是否存在
     * @param email 邮箱
     * @return 是否存在
     */
    boolean existsByEmail(String email);
    
    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param email 邮箱
     * @param nickname 昵称
     * @return 注册后的用户信息
     */
    SysUser register(String username, String password, String email, String nickname);
    
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户信息
     */
    SysUser login(String username, String password);
}