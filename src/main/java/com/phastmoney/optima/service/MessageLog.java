package com.phastmoney.optima.service;

import com.phastmoney.optima.model.ConsumedMessage;
import com.phastmoney.optima.repo.MessageLogs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 26/01/2023
 */

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageLog {

    private final MessageLogs logs;

    @Transactional
    public void processed(String eventId) {
        logs.save(ConsumedMessage.builder().eventId(eventId).timeOfReceiving(Instant.now()).build());
    }

    public boolean alreadyProcessed(String eventId) {
        return logs.findById(eventId).isPresent();
    }
}
