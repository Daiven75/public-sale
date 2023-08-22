package com.lucasilva.auction_consumer.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "lower_sale_value_limit")
    private BigDecimal lowerSaleValueLimit;

    @OneToMany(mappedBy = "product")
    private List<Proposal> proposals;

    public Product() {}

    private Product(Long id,
                    String name,
                    BigDecimal salePrice,
                    BigDecimal lowerSaleValueLimit,
                    List<Proposal> proposals) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.lowerSaleValueLimit = lowerSaleValueLimit;
        this.proposals = proposals;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public BigDecimal getLowerSaleValueLimit() {
        return lowerSaleValueLimit;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void addProposal(Proposal proposal) {
        requireNonNull(proposal, "proposal is required!");
        proposals.add(proposal);
    }

    public void updateSalePrice() {
        this.salePrice = proposals.stream()
                .map(Proposal::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(proposals.size()), RoundingMode.UNNECESSARY);
    }

}
