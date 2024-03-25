package org.ppf.model.dao;

import org.ppf.model.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDao extends CrudRepository<Transaction, Long> {

    List<Transaction> findByOwnAccountNumber(String ownAccountNumber);
}
