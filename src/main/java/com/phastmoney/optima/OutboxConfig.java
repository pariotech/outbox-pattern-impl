package com.phastmoney.optima;

import com.phastmoney.optima.event.OutboxEventListener;
import com.phastmoney.optima.repo.MessageLogs;
import com.phastmoney.optima.repo.OutboxEvents;
import com.phastmoney.optima.service.MessageLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Adesegun.Adeyemo on 02/02/2023
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
