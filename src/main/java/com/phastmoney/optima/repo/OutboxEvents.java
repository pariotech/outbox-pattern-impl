package com.phastmoney.optima.repo;

import com.phastmoney.optima.model.OutboxEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 14/11/2022
 */
@Repository
public interface OutboxEvents extends CrudRepository<OutboxEvent, String> {
}
