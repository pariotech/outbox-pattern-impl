package com.pario.outbox;

import com.pario.outbox.event.OutboxEventListener;
import com.pario.outbox.repo.MessageLogs;
import com.pario.outbox.repo.OutboxEvents;
import com.pario.outbox.service.MessageLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Temire.Emmanuel on 02/02/2023
 */
@Configuration
public class OutboxConfig {
    @Bean
    public OutboxEventListener outboxEventListener(OutboxEvents events) {
        return new OutboxEventListener(events);
    }

    @Bean
    public MessageLog messageLog(MessageLogs logs) {
        return new MessageLog(logs);
    }
}
