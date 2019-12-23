package com.dyw.springboot_cache.mapper;

import com.dyw.springboot_cache.bean.Department;
import org.apache.ibatis.annotations.Select;

public interface DeptMapper {

    @Select("SELECT * FROM department")
    Department getDeptById(Integer id);
}
