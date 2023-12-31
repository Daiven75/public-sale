package com.lucasilva.auctionservice.service;

import com.lucasilva.auctionservice.model.Product;
import com.lucasilva.auctionservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }
}
