package com.lucasilva.auctionproducer.scheduler;

import com.lucasilva.auctionproducer.avro.Proposal;
import com.lucasilva.auctionproducer.producer.ProposalEventProducer;
import com.lucasilva.auctionproducer.service.ProposalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.List;

@Component
class FetchProposalsProduct {

    private static final Logger log = LoggerFactory.getLogger(FetchProposalsProduct.class);

    private static final int timeDelay = 180000; // Milliseconds = 3 Minutes

    private final ProposalEventProducer proposalEventProducer;

    private final ProposalService proposalService;

    FetchProposalsProduct(ProposalEventProducer proposalEventProducer, ProposalService proposalService) {
        this.proposalEventProducer = proposalEventProducer;
        this.proposalService = proposalService;
    }

    @Scheduled(fixedDelay = timeDelay)
    List<Proposal> fetchProposalData() throws URISyntaxException {
        log.info("[SCHEDULED] Fetching Proposal Data......");

        List<Proposal> proposals = proposalService.getProposalInfo();

        log.info("[SCHEDULED] Found {} records", proposals.size());

        proposals.forEach(proposal -> {
            log.info("[SCHEDULED] Proposal with code: {} sent as event", proposal.getProduct().getCode());
            proposalEventProducer.sendProposalEvents(proposal);
        });

        return proposals;
    }
}
