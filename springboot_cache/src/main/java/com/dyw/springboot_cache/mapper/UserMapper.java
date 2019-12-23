package com.dyw.springboot_cache.mapper;

import com.dyw.springboot_cache.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface UserMapper {


    @Select("SELECT * FROM user WHERE id=#{id}")
    public User getUserById(Integer id);

    @Update("UPDATE user SET username=#{username}, email=#{email}, gender=#{gender} WHERE id=#{id}")
    public void updateUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    public void delUser(Integer id);

    @Insert(value = "INSERT INTO user(username, email, gender) VALUES (#{username}, #{email}, #{gender})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void insertUser(User user);

    @Select("SELECT * FROM user WHERE username = #{userName}")
    public User getUserByName(String userName);
}
