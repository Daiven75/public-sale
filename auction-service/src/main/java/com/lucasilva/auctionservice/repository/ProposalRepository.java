package com.lucasilva.auctionservice.repository;

import com.lucasilva.auctionservice.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {}
