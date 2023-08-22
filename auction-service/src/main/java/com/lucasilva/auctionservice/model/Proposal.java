package com.lucasilva.auctionservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 9, scale = 2)
    private BigDecimal value;

    private String author;

    private String email;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getAuthor() {
        return author;
    }

    public String getEmail() {
        return email;
    }

    public Product getProduct() {
        return product;
    }
}
