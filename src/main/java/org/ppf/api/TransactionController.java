package org.ppf.api;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.ppf.api.dto.TransactionDto;
import org.ppf.logic.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/createTransactions")
    public void createTransactions(@RequestBody List<TransactionDto> transactionDtoList) {
        transactionService.saveTransactions(transactionDtoList);
    }

    @GetMapping("/accounts/{ownAccountNumber}/transactions")
    public List<TransactionDto> getAccountTransactions(@PathVariable String ownAccountNumber) {
        return transactionService.fetchAccountTransactions(ownAccountNumber);
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDataAccessException(
        DataAccessException exception,
        WebRequest request
    ){
        return ExceptionUtils.getRootCauseMessage(exception);
    }
}
