package org.ppf.model.dao;

import org.ppf.model.entity.Transaction;
import org.ppf.model.entity.TransactionAmount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionDao extends CrudRepository<Transaction, Long> {

    List<Transaction> findByOwnAccountNumber(String ownAccountNumber);
    List<Transaction> findByTransactionTypeCode(Integer code);
    List<Transaction> findByStatementNumber(String number);
    List<Transaction> findByCounterPartyAccountNumber(String number);

    @Query(value = "SELECT new org.ppf.model.entity.TransactionAmount(sum(t.amount), t.creditDebitIndicator, t.currency) from Transaction as t " +
                   "GROUP BY t.ownAccountNumber, t.currency, t.creditDebitIndicator HAVING t.ownAccountNumber = :ownAccountNumber")
    List<TransactionAmount> sumAccountTransactions(@Param("ownAccountNumber") String ownAccountNumber);
}
