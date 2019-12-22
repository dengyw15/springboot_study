package com.dyw.springboot_cache.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String email;
    private String gender;
}
