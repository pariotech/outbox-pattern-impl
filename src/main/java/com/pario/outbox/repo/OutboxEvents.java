package com.pario.outbox.repo;

import com.pario.outbox.model.OutboxEvent;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Temire.Emmanuel on 14/11/2022
 */
public interface OutboxEvents extends CrudRepository<OutboxEvent, Long> {
}
