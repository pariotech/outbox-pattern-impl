package com.pario.outbox.repo;

import com.pario.outbox.model.ConsumedMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Temire.Emmanuel on 26/01/2023
 */
public interface MessageLogs extends CrudRepository<ConsumedMessage, String> {

}
