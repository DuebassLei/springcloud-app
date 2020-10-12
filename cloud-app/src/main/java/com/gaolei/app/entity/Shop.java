package com.gaolei.app.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/9/29 18:04
 */
@Data
@Document(indexName = "cloud",type = "es_shop")
public class Shop implements Serializable {
    private static final long serialVersionUID = -4649431125711425081L;
    private String id;
    /**
     * 商品名称
     * */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String shopname;

    /**
     * 优惠价格
     * */
    private Long reducedprice;
}
