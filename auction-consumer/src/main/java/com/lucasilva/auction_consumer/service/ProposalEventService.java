package com.lucasilva.auction_consumer.service;

import avro.kafka.model.Proposal;
import com.lucasilva.auction_consumer.repository.ProductRepository;
import com.lucasilva.auction_consumer.repository.ProposalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProposalEventService {

    private static final Logger log = LoggerFactory.getLogger(ProposalEventService.class);

    private final ProposalRepository proposalRepository;

    private final ProductRepository productRepository;

    public ProposalEventService(ProposalRepository proposalRepository, ProductRepository productRepository) {
        this.proposalRepository = proposalRepository;
        this.productRepository = productRepository;
    }

    public void process(Proposal proposalEvent) {
        log.info("[PROPOSAL-EVENT] [PROCESSING] {}", proposalEvent);

        var product = productRepository.findByCode(proposalEvent.getProduct().getCode());

        if(product.isEmpty()) {
            log.warn("[PROPOSAL-EVENT] [NOT-FOUND] product with {} code is not part of our catalog",
                    proposalEvent.getProduct().getCode());
            return;
        }

        var foundProduct = product.get();

        if(bidValueIsLessThanLimitSale(foundProduct.getLowerSaleValueLimit(), proposalEvent.getBidValue())) {
            log.warn("[PROPOSAL-EVENT] [REFUSED] proposal value {} is less than the minimum acceptable value {}",
                    foundProduct.getLowerSaleValueLimit(), proposalEvent.getBidValue());
            return;
        }

        var proposal = com.lucasilva.auction_consumer.model.Proposal.toProposal(proposalEvent);
        proposal.linkToProduct(foundProduct);
        proposalRepository.save(proposal);

        foundProduct.addProposal(proposal);
        foundProduct.updateSalePrice();
        productRepository.save(foundProduct);

        log.info("[PROPOSAL-EVENT] [PROCESSED] product {} update with proposal value {} added",
                foundProduct.getName(), proposal.getValue());
    }

    private boolean bidValueIsLessThanLimitSale(BigDecimal limitLowerSaleValue, BigDecimal proposalValue) {
        return limitLowerSaleValue.compareTo(proposalValue) > 0;
    }
}
