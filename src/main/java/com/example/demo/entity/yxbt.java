package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @ClassName yxbt
 * @Descriptino
 * @Author myzhen
 * @Date 2020/8/5 上午9:49
 * @Version 1.0
 **/
@Data
@SolrDocument(collection = "yxbtk")
public class yxbt {

    /**
     * ID 主键
     */
    @Id
    @Indexed(name = "id", type = "int")
    private Integer id;
    /**
     * 概念ID
     */
    @Indexed(name = "conceptId", type = "string")
    private String conceptId;
    /**
     * 拼音
     */
    @Indexed(name = "pinYin", type = "string")
    private String pinYin;
    /**
     * 校验状态
     */
    @Indexed(name = "checkStatus", type = "string")
    private String checkStatus;
    /**
     * 删除标识
     */
    @Indexed(name = "deflag", type = "string")
    private String deflag;
    /**
     * 英文名称
     */
    @Indexed(name = "conceptId", type = "string")
    private String conceptEnglishName;
    /**
     * 中文名称
     */
    @Indexed(name = "conceptChineseName", type = "string")
    private String conceptChineseName;
    /**
     *
     */
    @Indexed(name = "moduleName", type = "string")
    private String moduleName;
    /**
     *
     */
    @Indexed(name = "moduleCode", type = "string")
    private String moduleCode;
    /**
     * 近义词ID
     */
    @Indexed(name = "ewellCTSynonymsId", type = "string")
    private String ewellCTSynonymsId;
    /**
     * 近义词名称
     */
    @Indexed(name = "ewellCTSynonymsName", type = "string")
    private String ewellCTSynonymsName;
    /**
     * 同义词ID
     */
    @Indexed(name = "homoionymId", type = "string")
    private String homoionymId;
    /**
     * 同义词名称
     */
    @Indexed(name = "homoionymName", type = "string")
    private String homoionymName;
    /**
     * 父级ID
     */
    @Indexed(name = "fatherId", type = "string")
    private String fatherId;
    /**
     * 父级名称
     */
    @Indexed(name = "fatherName", type = "string")
    private String fatherName;
    /**
     * 子级ID
     */
    @Indexed(name = "childrenId", type = "string")
    private String childrenId;
    /**
     * 子级名称
     */
    @Indexed(name = "childrenName", type = "string")
    private String childrenName;
    /**
     * 语义关系/映射 类别
     */
    @Indexed(name = "classify", type = "string")
    private String classify;
    /**
     *
     */
    @Indexed(name = "type", type = "string")
    private String type;
    /**
     * 语义关系/映射 ID
     */
    @Indexed(name = "mapID", type = "string")
    private String mapID;

    /**
     * 语义关系/映射 名称
     */
    @Indexed(name = "mapName", type = "string")
    private String mapName;
}
