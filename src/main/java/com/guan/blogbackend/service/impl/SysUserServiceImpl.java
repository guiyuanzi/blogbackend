package com.guan.blogbackend.service.impl;

import com.guan.blogbackend.entity.SysUser;
import com.guan.blogbackend.repository.SysUserRepository;
import com.guan.blogbackend.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 需要在配置类中定义PasswordEncoder

    @Override
    public Optional<SysUser> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<SysUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<SysUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public SysUser save(SysUser sysUser) {
        return userRepository.save(sysUser);
    }

    @Override
    @Transactional
    public SysUser update(SysUser sysUser) {
        return userRepository.save(sysUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<SysUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    @Transactional
    public SysUser register(String username, String password, String email, String nickname) {
        // 验证用户名和邮箱是否已存在
        if (existsByUsername(username)) {
            throw new RuntimeException("用户名已存在");
        }
        if (existsByEmail(email)) {
            throw new RuntimeException("邮箱已存在");
        }

        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // 加密密码
        user.setEmail(email);
        user.setNickname(nickname);
        user.setStatus(1); // 默认为正常状态
        user.setUserRole(0); // 默认为普通用户

        return userRepository.save(user);
    }

    @Override
    public SysUser login(String username, String password) {
        SysUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户名不存在"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        if (user.getStatus() != 1) {
            throw new RuntimeException("账号已禁用");
        }

        return user;
    }
}