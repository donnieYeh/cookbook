package com.yejf.cookbook.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Dish {
    private String id;
    /**
     * 菜名
     */
    @NotBlank
    private String name;
    private String desc;
    private String url;
}