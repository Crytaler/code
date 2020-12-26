package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName FileMetadata
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/23 上午11:11
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "file_metadata")
public class FileMetadata {

    @Id
    // 这应该不是数据库生成，而是mongo那边的ID
//    @GeneratedValue(generator = "uuidMongoFiles")
//    @GenericGenerator(name = "uuidMongoFiles", strategy = "uuid")
    @Column(name = "id", columnDefinition = "varchar(128) COMMENT '编号'")
    private String id;

    @Column(name = "FILE_TYPE", columnDefinition = "varchar(20) COMMENT '文件类型，如资质文件、协议文件等'")
    private String fileType;

    @Column(name = "OBJECT_ID", columnDefinition = "varchar(128) COMMENT '关联的ID'")
    private String associateId;

    @Column(name = "OBJECT_CLASS", columnDefinition = "varchar(20) COMMENT '关联的实体类型'")
    private String associateObjectClass;

    @Column(name = "FILE_SEQ_NO", columnDefinition = "SMALLINT COMMENT '文件顺序'")
    private Integer fileOrder;

    @Column(name = "FILE_ORIGIN_NAME", columnDefinition = "varchar(255) COMMENT '上传文件原名'")
    private String fileOriginName;

    @Column(name = "FILE_DISPLAY_NAME", columnDefinition = "varchar(255) COMMENT '文件的标准展示名'")
    private String fileDisplayName;

    @Column(name = "FILE_YEAR", columnDefinition = "SMALLINT COMMENT '资料相关的年份'")
    private Integer year;

    @Column(name = "UPLOAD_TIME", columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间'")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp uploadTime;

    @Column(name = "MEMO", columnDefinition = "varchar(255) COMMENT '备注信息'")
    private String comment;

    @Column(name = "OPERATOR", columnDefinition = "varchar(50) COMMENT '操作员'")
    private String operator;

    @Transient
    private String viewPtah;
}
