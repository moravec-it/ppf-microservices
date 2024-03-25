package org.ppf.model.dao;

import org.ppf.model.entity.Statement;
import org.springframework.data.repository.CrudRepository;

public interface StatementDao extends CrudRepository<Statement, Long> {

    Statement findByNumber(String number);
}
