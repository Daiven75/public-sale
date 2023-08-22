package com.lucasilva.auctionservice.repository;

import com.lucasilva.auctionservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
