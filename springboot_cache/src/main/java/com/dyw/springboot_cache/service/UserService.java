package com.dyw.springboot_cache.service;

import com.dyw.springboot_cache.bean.User;
import com.dyw.springboot_cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(value = "user")
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @CachePut(value = "user", key = "#user.id")
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @CacheEvict(value = "user")
    public void deleteUser(Integer id) {
        userMapper.delUser(id);
    }

    @Cacheable(value = "user", key = "#user.id")
    public User saveUser(User user) {
        return userMapper.insertUser(user);
    }

    public List<User> getAllUsers() {
        return userMapper.getUserList();
    }
}
