package org.ppf.model.dao;

import org.ppf.model.entity.TransactionType;
import org.springframework.data.repository.CrudRepository;

public interface TransactionTypeDao extends CrudRepository<TransactionType, Long> {

    TransactionType findByCode(Integer code);
}
