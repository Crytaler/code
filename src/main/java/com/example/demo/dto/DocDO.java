package com.example.demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


/**
 * @ClassName UserDto
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/8/4 上午9:45
 * @Version 1.0
 **/
@Data
public class DocDO {

    /**
     * id
     */
    @Id
    @Field
    private int id;

    /**
     * 内容
     */
    @Field("content")
    private String content;

    /**
     * 标题
     */
    @Field("title")
    private String title;


    /**
     * name  这个没设置中文分词
     */
    @Field("type")
    private String type;
}
