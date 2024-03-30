package com.example.productservice_proxy.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
@Document(indexName = "productservice") // This annotation is used to specify the index name in Elasticsearch which is Database name in SQL. To understand more about this annotation, please refer to the link: https://blog.avenuecode.com/elasticsearch
public class Product extends BaseModel{
    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Categories category;
    private String imageUrl;
}
