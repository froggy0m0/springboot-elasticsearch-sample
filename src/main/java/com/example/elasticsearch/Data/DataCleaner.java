package com.example.elasticsearch.Data;

import com.example.elasticsearch.Product.repository.ProductRepository;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataCleaner {

    private final ProductRepository productRepository;

    public DataCleaner(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PreDestroy
    public void removeData() {
        // Elasticsearch 인덱스에서 모든 데이터 삭제
        productRepository.deleteAll();
        log.info("dummy데이터 삭제");
    }
}
