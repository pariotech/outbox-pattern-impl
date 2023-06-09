package com.pario.outbox.repo;

import com.pario.outbox.model.OutboxEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adesegun.Adeyemo on 14/11/2022
 */
@Repository
public interface OutboxEvents extends CrudRepository<OutboxEvent, String> {
}
