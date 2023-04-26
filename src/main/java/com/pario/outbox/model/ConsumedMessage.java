package com.pario.outbox.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 26/01/2023
 */
@Value
@Builder
@Table("consumed_messages")
public class ConsumedMessage {

    @Id
    @Column("event_id")
    String eventId;
    Instant timeOfReceiving;
    @Version
    int version;
}
