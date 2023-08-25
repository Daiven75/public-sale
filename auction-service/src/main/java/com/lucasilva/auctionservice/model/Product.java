package com.lucasilva.auctionservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "products_id_seq", allocationSize = 1)
    private Long id;

    private String code;

    private String name;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "lower_sale_value_limit")
    private BigDecimal lowerSaleValueLimit;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Proposal> proposals;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
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
}
