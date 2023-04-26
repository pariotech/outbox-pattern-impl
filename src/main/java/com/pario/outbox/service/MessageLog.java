package com.pario.outbox.service;

import com.pario.outbox.model.ConsumedMessage;
import com.pario.outbox.repo.MessageLogs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

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
