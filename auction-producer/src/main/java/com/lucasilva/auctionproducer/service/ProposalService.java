package com.lucasilva.auctionproducer.service;

import avro.kafka.model.Proposal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Objects.nonNull;

@Service
public class ProposalService {

    @Value("${third-party-service.url}")
    private String url;

    private final RestTemplate restTemplate;

    public ProposalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Proposal> getProposalInfo() {
        var response = restTemplate.getForEntity(url, Proposal[].class);
        if(response.getStatusCode().is2xxSuccessful() && nonNull(response.getBody())) {
            return List.of(response.getBody());
        }
        return emptyList();
    }
}
