package com.example.elasticsearch.Product.repository;

import com.example.elasticsearch.Product.entitiy.Product;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    /**
     * 키워드 검색
     * @param description
     * @return
     */
    List<Product> findByDescription (String description);
}
