package com.gaolei.app.repository;

import com.gaolei.app.entity.Shop;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/9/29 17:29
 */
public interface EsRepository extends ElasticsearchRepository<Shop,String> {
}
