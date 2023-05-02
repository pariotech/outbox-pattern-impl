package com.pario.outbox.event;

import com.pario.outbox.model.OutboxEvent;
import com.pario.outbox.repo.OutboxEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.UUID;

/**
 * Created by Temire.Emmanuel on 21/01/2023
 */

@RequiredArgsConstructor
public class OutboxEventListener {

    private final OutboxEvents events;

    @EventListener
    public void handleOutboxEvent(ExportedEvent event) {
        var e = of(event);
        events.save(e);
        events.delete(e);
    }

    private static OutboxEvent of(ExportedEvent exportedEvent) {
        return OutboxEvent.builder()
                .aggregateId(exportedEvent.getAggregateId())
                .aggregateType(exportedEvent.getAggregateType())
                .type(exportedEvent.getType())
                .timestamp(exportedEvent.getTimestamp())
                .payload(exportedEvent.getPayload().toPrettyString()).build();

    }
}
