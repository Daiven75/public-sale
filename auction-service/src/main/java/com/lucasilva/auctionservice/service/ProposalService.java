package com.lucasilva.auctionservice.service;

import com.lucasilva.auctionservice.model.Proposal;
import com.lucasilva.auctionservice.repository.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;

    public ProposalService(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public List<Proposal> findAllProposals() {
        return proposalRepository.findAll();
    }

    public Proposal findProposalById(Long proposalId) {
        return proposalRepository.findById(proposalId).orElseThrow();
    }
}
