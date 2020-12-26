package com.example.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Jdbc
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/9/22 下午8:44
 * @Version 1.0
 **/
@Data
public class Jdbc {



    private String tableName;

    private List<Condition> conditionList;

    @Data
    public static
    class Condition {

        private String column;

        private String type;

        private String num;

        private String action;

        private String comment;

    }
}
