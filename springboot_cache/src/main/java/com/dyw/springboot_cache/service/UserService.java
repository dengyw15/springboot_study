package com.dyw.springboot_cache.service;

import com.dyw.springboot_cache.bean.User;
import com.dyw.springboot_cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userMapper.delUser(id);
    }

    public void saveUser(User user) {
        userMapper.insertUser(user);
    }
}
