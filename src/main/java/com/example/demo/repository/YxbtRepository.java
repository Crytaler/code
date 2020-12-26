package com.example.demo.repository;

import com.example.demo.entity.yxbt;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @ClassName YxbtRepository
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/8/5 上午10:27
 * @Version 1.0
 **/
public interface YxbtRepository extends SolrCrudRepository<yxbt, Integer> {
}
