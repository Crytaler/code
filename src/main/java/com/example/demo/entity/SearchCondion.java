package com.example.demo.entity;

import lombok.Data;

/**
 * @ClassName search
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/28 下午6:13
 * @Version 1.0
 **/
@Data
public class SearchCondion {

    private String type;

    private String column;

    private String  relation;

    private String condition;
}
