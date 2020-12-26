package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName MongoFileMetaDate
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/23 上午11:14
 * @Version 1.0
 **/
@Data
public class MongoFileMetaDate {

    private String fileName;
    private String relatedOrgId;
    private String uploadUser;
    private LocalDateTime uploadTime;
    private String comment;
    private String FileOriginName;

}
