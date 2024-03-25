package org.ppf.model.dao;

import org.ppf.model.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account, Long> {

    Account findByNumber(String number);
}
