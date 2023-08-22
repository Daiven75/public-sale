package com.lucasilva.auction_consumer.consumer;

import avro.kafka.model.Proposal;
import com.lucasilva.auction_consumer.service.ProposalEventService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProposalEventsConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProposalEventsConsumer.class);

    private final ProposalEventService proposalEventService;

    public ProposalEventsConsumer(ProposalEventService proposalEventService) {
        this.proposalEventService = proposalEventService;
    }

    @KafkaListener(topics = "proposal-product-events")
    public void onMessage(ConsumerRecord<String, Proposal> record) {
        log.info("[EVENT-CONSUMER] ConsumerRecord: key = {}", record.key());
        proposalEventService.process(record.value());
    }

}
