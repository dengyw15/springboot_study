package com.dyw.springboot_cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.dyw.springboot_cache.mapper")
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}

/*
 * 整合redis作为缓存
 * Redis是一个开源的内存中的数据结构存储系统，它开源用作数据库、缓存和消息中间件
 * 1、安装redis，使用docker（安装在阿里云虚拟机中）
 * 2、在pom.xml中引入redis的starter
 * 3、配置redis  在yml文件中配置 （相关单元测试案例可见测试类中）
 * 4、测试缓存：
 *      原理：CacheManager创建出Cache缓存组件，缓存组件实现给缓存中存取数据
 *      1) 引入redis的starter，容器中保存的是RedisCacheManager
 *      2) RedisCacheManager帮我们创建RedisCache作为缓存组件，它通过redis来缓存数据
 *      3) 默认保存数据K-V都是Object利用序列化来保存（默认是使用jdk序列化来保存），如何使用json来保存数据？
 *          引入了redis 的starter，CacheManager变成了RedisCacheManager
 *          默认创建的RedisCacheManager操作Redis时使用的是RedisTemplate<Object, Object>
 *          RedisTemplate<Object, Object>是默认使用jdk的序列化机制
 *      4)自定义序列化
 */


