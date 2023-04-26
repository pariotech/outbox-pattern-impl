package com.phastmoney.optima.repo;

import com.phastmoney.optima.model.ConsumedMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Adesegun.Adeyemo on 26/01/2023
 */
public interface MessageLogs extends CrudRepository<ConsumedMessage, String> {

}
