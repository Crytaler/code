package com.example.demo.service;

import com.example.demo.dto.DocDO;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @ClassName ProductRepository
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/8/4 上午10:02
 * @Version 1.0
 **/
public interface ProductRepository extends SolrCrudRepository<DocDO, Integer> {
}
