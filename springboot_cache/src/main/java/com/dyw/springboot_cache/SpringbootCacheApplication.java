package com.dyw.springboot_cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
/*
 * springboot默认开启的是SimpleCacheConfiguration
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache，将数据保存到ConcurrentHashMap中
 * 开发中使用魂村中间件：redis、memcached、ehcache
 */
@EnableCaching
//指定mybatis需要扫描的mapper接口所在的包，如果不在此处指定，就需要在每个mapper接口上面用@Mapper注解
@MapperScan("com.dyw.springboot_cache.mapper")
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}

/*
 * 整合redis：
 * 1、安装redis，使用docker安装
 */
