package com.dyw.springboot_cache.service;

import com.dyw.springboot_cache.bean.Department;
import com.dyw.springboot_cache.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "dept")
public class DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Autowired
    RedisCacheManager redisCacheManager;

    @Cacheable
    public Department getDeptById(Integer id) {
       Department department = deptMapper.getDeptById(id);
       return department;
    }

    /*
     * 有时候不用注解的方式 而是用编码的方式向redis中写入缓存
     */
/*    public Department getDeptById(Integer id) {
        Department deptById = deptMapper.getDeptById(id);
        Cache dept = redisCacheManager.getCache("dept");
        dept.put("dept:1", deptById);
        return deptById;
    }*/

}
