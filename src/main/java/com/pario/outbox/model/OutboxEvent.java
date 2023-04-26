package com.pario.outbox.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 14/11/2022
 */
@Table("outbox_events")
@Value
@Builder
public class OutboxEvent { // Configure and ensure binlog retention is not too short

    /**
     * Unique id of each message;
     * can be used by Kafka consumers to detect any duplicate events, e.g. when restarting to read messages after a failure.
     * Generated when creating a new event.
     */
    @Id
    String id;
    String aggregateType;
    Long aggregateId;
    String type;
    String payload;
    Instant timestamp;
    @Version
    Integer version;
}
