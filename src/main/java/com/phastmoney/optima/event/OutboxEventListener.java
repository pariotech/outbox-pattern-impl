package com.phastmoney.optima.event;

import com.phastmoney.optima.model.OutboxEvent;
import com.phastmoney.optima.repo.OutboxEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 21/01/2023
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
                .id(UUID.randomUUID().toString())
                .aggregateId(exportedEvent.getAggregateId())
                .aggregateType(exportedEvent.getAggregateType())
                .type(exportedEvent.getType())
                .timestamp(exportedEvent.getTimestamp())
                .payload(exportedEvent.getPayload().toPrettyString()).build();

    }
}
