package com.dyw.springboot_cache;

import com.dyw.springboot_cache.bean.User;
import com.dyw.springboot_cache.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作K-V都是字符串的

    //使用自定义的redisTemplate 实现json序列化
//    @Autowired
//    RedisTemplate redisTemplate; //操作K-V都是对象的

    @Autowired
    RedisTemplate redisTemplate;

   @Test
    void getUserById() {
        System.out.println(userService.getUserById(1));
    }

    /**
     * Redis常见五大数据类型
     * String 、 list、 Set、 Hash、 ZSet
     * 分别对应
     * stringRedisTemplate.opsForString()
     * stringRedisTemplate.opsForList()
     * stringRedisTemplate.opsForSet()
     * stringRedisTemplate.opsForHash()
     * stringRedisTemplate.opsForZSet()
     */
    @Test
    void redisTest01() {
        //给redis中保存数据
//       stringRedisTemplate.opsForValue().append("msg", "hello"); //追加值

       /* String msg = stringRedisTemplate.opsForValue().get("msg"); //读取
        System.out.println(msg);*/

       stringRedisTemplate.opsForList().leftPush("mylist", "1");
       stringRedisTemplate.opsForList().leftPush("mylist", "2");
        Long mylist = stringRedisTemplate.opsForList().size("mylist");
        System.out.println(mylist);
        String mylist1 = stringRedisTemplate.opsForList().leftPop("mylist");
        System.out.println(mylist1);

    }

    @Test
    void redisTest02() {
        User user = userService.getUserById(1);

        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("user", user);
        /*将数据以json方式进行保存
         * 方法一：调用JSON工具对对象序列化后再保存
         * 方法二：自定义redis序列化器。在config包下配置MyRedisConfig使用jackson2的对象序列化器
         */

        redisTemplate.opsForValue().set("user02", user);
    }

    @Test
    void contextLoads() {
    }

}
