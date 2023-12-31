package com.lucasilva.auctionproducer.producer;

import avro.kafka.model.Proposal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class ProposalEventProducer {

    private static final Logger log = LoggerFactory.getLogger(ProposalEventProducer.class);

    private final KafkaTemplate<String, Proposal> kafkaTemplate;

    public ProposalEventProducer(KafkaTemplate<String, Proposal> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProposalEvents(Proposal proposal) {
        var productCode = proposal.getProduct().getCode();

        var sendProposalEvent = kafkaTemplate.sendDefault(productCode, proposal);
        
        sendProposalEvent.whenComplete((result, error) -> {
            if(isNull(result)) {
                log.error("[EVENT-PRODUCER] Error to send message, the exception is {}", error.getMessage());
            } else {
                log.info("[EVENT-PRODUCER] Message Sent SuccessFully for the key: {} and the value is {} | partition is {}",
                        productCode,
                        proposal,
                        result.getRecordMetadata().partition());
            }
        });
    }
}
