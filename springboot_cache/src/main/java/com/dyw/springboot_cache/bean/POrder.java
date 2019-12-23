package com.dyw.springboot_cache.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class POrder implements Serializable {
    private Integer id;
    private String product;
    private Integer count;
}
