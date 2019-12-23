package com.dyw.springboot_cache.controller;

import com.dyw.springboot_cache.bean.User;
import com.dyw.springboot_cache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Integer deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return id;
    }

    @PostMapping("/saveUser")
    public Integer saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getUserByName/{userName}")
    public User getUserByName(@PathVariable("userName") String userName) {
        return userService.getUserByName(userName);
    }
}
