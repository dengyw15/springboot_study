package com.dyw.springboot_cache.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {

    private Integer id;
    private String name;
}
