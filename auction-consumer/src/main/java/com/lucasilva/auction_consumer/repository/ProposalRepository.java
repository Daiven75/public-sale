package com.lucasilva.auction_consumer.repository;

import com.lucasilva.auction_consumer.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {}
