package com.pario.outbox.repo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pario.outbox.model.OutboxEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 16/01/2023
 */
@Slf4j
@ImportAutoConfiguration(JacksonAutoConfiguration.class)
public class OutboxEventsTest extends AbstractDatabaseTest {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private OutboxEvents events;

    @Test
    void testCreateEvent() {
        JsonNode asJson = mapper.createObjectNode()
                .put("id", 1)
                .put("customerId", "alex@me.com")
                .put("amount", String.valueOf(100000))
                .put("currency", "NGN")
                .put("transactionRef", UUID.randomUUID().toString());
        OutboxEvent event = OutboxEvent.builder()
                .id(UUID.randomUUID().toString())
                .aggregateType("Transaction")
                .aggregateId(1L)
                .timestamp(Instant.now())
                .type("TransactionSubmitted")
                .payload(asJson.toPrettyString()).build();
        OutboxEvent saved = events.save(event);
        log.info("Saved - " + saved);
        Optional<OutboxEvent> found = events.findById(saved.getId());
        log.info("Found - " + found.get());
    }
}
