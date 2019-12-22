package com.dyw.springboot_cache.mapper;

import com.dyw.springboot_cache.bean.POrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface POrderMapper {

    @Update("UPDATE porder SET product=#{product}, count=#{count} WHERE id=#{id}")
    void updateById(POrder POrder);

    @Insert("INSERT INTO porder (product, count) VALUES (#{product}, #{count})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(POrder POrder);

    @Delete("DELETE FROM porder WHERE id=#{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM porder")
    List<POrder> findAll();

    @Select("SELECT * FROM porder WHERE id=#{id}")
    POrder selectById(Integer id);

    @Select("SELECT COUNT(*) FROM porder")
    Integer selectCount();
}
