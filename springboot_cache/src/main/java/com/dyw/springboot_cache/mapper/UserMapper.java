package com.dyw.springboot_cache.mapper;

import com.dyw.springboot_cache.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface UserMapper {

    @Cacheable(value = "user")
    @Select("SELECT * FROM user WHERE id=#{id}")
    public User getUserById(Integer id);

    @CachePut(value = "user", key = "#user.id")
    @Update("UPDATE user SET username=#{username}, email=#{email}, gender=#{gender} WHERE id=#{id}")
    public void updateUser(User user);

    @CacheEvict(value = "user")
    @Delete("DELETE FROM user WHERE id=#{id}")
    public void delUser(Integer id);

    @Insert("INSERT INTO user(username, email, gender) VALUES (#{username}, #{email}, #{gender})")
    public void insertUser(User user);
}
