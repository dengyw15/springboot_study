package com.dyw.springboot_cache;

import com.dyw.springboot_cache.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void getUserById() {
        System.out.println(userService.getUserById(1));
    }

    @Test
    void contextLoads() {
    }

}
