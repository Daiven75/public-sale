package com.lucasilva.auctionservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "proposals_id_seq", allocationSize = 1)
    private Long id;

    @Column(precision = 9, scale = 2)
    private BigDecimal value;

    private String author;

    private String email;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
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
