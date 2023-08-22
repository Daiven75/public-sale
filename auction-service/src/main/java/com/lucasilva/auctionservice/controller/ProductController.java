package com.lucasilva.auctionservice.controller;

import com.lucasilva.auctionservice.model.Product;
import com.lucasilva.auctionservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    Product findProductById(@PathVariable Long productId) {
        return productService.findProductById(productId);
    }

    @GetMapping
    List<Product> findAllProducts() {
        return productService.findAllProducts();
    }
}
