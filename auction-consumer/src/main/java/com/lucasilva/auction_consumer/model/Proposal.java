package com.lucasilva.auction_consumer.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

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

    public Proposal() {}

    private Proposal(BigDecimal value, String author, String email) {
        this.value = value;
        this.author = author;
        this.email = email;
    }

    public static Proposal toProposal(avro.kafka.model.Proposal proposalEvent) {
        return new Proposal(
                proposalEvent.getBidValue(),
                proposalEvent.getAuthor().getName(),
                proposalEvent.getAuthor().getEmail());
    }

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

    public void linkToProduct(Product product) {
        requireNonNull(product, "product is required!");
        this.product = product;
    }
}
