package com.lucasilva.auctionservice.controller;

import com.lucasilva.auctionservice.model.Proposal;
import com.lucasilva.auctionservice.service.ProposalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proposal")
public class ProposalController {

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GetMapping("/{proposalId}")
    Proposal findProposalById(@PathVariable Long proposalId) {
        return proposalService.findProposalById(proposalId);
    }

    @GetMapping
    List<Proposal> findAllProposals() {
        return proposalService.findAllProposals();
    }
}
