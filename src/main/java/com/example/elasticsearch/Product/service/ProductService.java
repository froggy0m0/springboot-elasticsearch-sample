package com.example.elasticsearch.Product.service;

import com.example.elasticsearch.Product.entitiy.Product;
import com.example.elasticsearch.Product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> searchByDescription(String description) {
        return productRepository
            .findByDescription(description);
    }

    public Product searchById(String id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product with ID " + id + " not found"));
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product productDetails) {
        Product searchProduct = searchById(productDetails.getId());

        searchProduct.setName(productDetails.getName());
        searchProduct.setDescription(productDetails.getDescription());

        return productRepository.save(productDetails);
    }
}