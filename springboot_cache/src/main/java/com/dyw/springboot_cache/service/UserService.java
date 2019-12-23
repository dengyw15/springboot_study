package com.dyw.springboot_cache.service;

import com.dyw.springboot_cache.bean.User;
import com.dyw.springboot_cache.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/*
 * 在类上面使用@CacheConfig注解，可以指定当前类中定义的方法公共的配置
 */
//@CacheConfig(cacheNames = "user")
@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    /*
     *Cacheable: 是在调用方法之前就调用，并检查缓存
     * value/cacheNames:指定缓存组件的名称。将方法返回的结果放到哪个缓存中，是数组的形式，可以指定多个缓存
     * key：缓存数据使用的key。默认是使用方法参数的值。 支持SpELl表达式
     * keyGenerator:key生成器，可以自己指定key的生成器组件id   key/keyGenerator 二选一
     * cacheManager：指定缓存管理器。
     *
     * condition： 指定符合条件的情况下才缓存  如condition = "#a0>1" 当第一个参数大于1 时才缓存
     * unless: 否定缓存。  unless指定的条件为true 则不会被缓存
     * sync:是否异步模式。
     */
    @Cacheable(value = "user"/*, keyGenerator = "myKeyGenerator"*/)  //在config包下创建myKeyGenerator的bean
    public User getUserById(Integer id) {
        log.info("getUserById");
        return userMapper.getUserById(id);
    }

    /**
     * @CachePut 既调用方法，又更新缓存。如果修改了数据库的某个数据，同时更新缓存
     * 运行时机：先调用目标方法，再将目标方法的结果缓存起来
     *
     * 需要保证和Cacheable中的value、key一致  才能更新
     */
    @CachePut(value = "user", key = "#user.id") //key="#result.id"
    public User updateUser(User user) {
        log.info("更新用户" + user);
        userMapper.updateUser(user);
        return user;
    }

    /*
     * @CacheEvict： 清除缓存
     * key指定要删除的key值
     * allEntries: 为true时表示删除所有缓存
     * beforeInvocation: 默认为false， 缓存清楚是否在方法执行之前执行。 默认是在方法执行之后执行，这样如果方法发生异常，缓存就不会被清楚
     *
     */
    @CacheEvict(value = "user", key = "#id"/*, allEntries = true*/)
    public void deleteUser(Integer id) {
        log.info("删除用户" + id);
        userMapper.delUser(id);
    }

    @CachePut(value = "user", key = "#user.id")
    public Integer saveUser(User user) {
        userMapper.insertUser(user);
        return user.getId();
    }

    /*
     * @Caching：可以定义复杂的组合缓存
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "user", key = "#userName")
            },
            put = {
                    @CachePut(value = "user", key = "#result.id"),
                    @CachePut(value = "user", key = "#result.email")
            }
    )
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }
}
