package com.example.elasticsearch.Product.controller;

import com.example.elasticsearch.Product.entitiy.Product;
import com.example.elasticsearch.Product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class  ProductController {

    private final ProductService productService;

    /**
     * 상품 등록
     * @param product
     * @return
     */
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    /**
     * 상품 키워드 검색
     * @param description
     * @return
     */
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String description) {
        return productService.searchByDescription(description);
    }

    /**
     * 상품 상세 조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Product detailProduct(@PathVariable String id) {
        return productService.searchById(id);
    }

    /**
     * 상품 수정
     * @param productDetails
     * @return
     */
    @PutMapping()
    public Product updateProduct(@RequestBody Product productDetails) {
        return productService.updateProduct(productDetails);
    }


    /**
     * 상품 삭제
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteById(id);
    }
}
