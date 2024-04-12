package com.example.elasticsearch.Data;

import com.example.elasticsearch.Product.entitiy.Product;
import com.example.elasticsearch.Product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataLoader {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            // 더미 데이터 생성 및 저장
            Product p1 = Product.builder()
                .name("삼성 보조배터리")
                .description("강력한 성능, 휴대성이 뛰어난 삼성 보조배터리")
                .build();

            Product p2 = Product.builder()
                .name("LG 보조배터리")
                .description("긴 사용 시간을 자랑하는 LG 보조배터리")
                .build();

            Product p3 = Product.builder()
                .name("LG 냉장고")
                .description("긴 사용 시간 신선함을 오래 유지하는 LG 냉장고")
                .build();

            Product p4 = Product.builder()
                .name("삼성 갤럭시북v2")
                .description("강력한 성능의 Samsung 갤럭시북")
                .build();

            Product p5 = Product.builder()
                .name("LG 그램")
                .description("가벼운 무게와 강력한 성능을 갖춘 LG 그램v2")
                .build();

            // 더미 데이터 저장
            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);
            productRepository.save(p4);
            productRepository.save(p5);

            log.info("dummy 데이터 저장");
        };
    }
}
