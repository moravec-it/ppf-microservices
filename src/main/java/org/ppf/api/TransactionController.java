package org.ppf.api;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.ppf.api.dto.TransactionDto;
import org.ppf.api.dto.TransactionSaveLogDto;
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
    public TransactionSaveLogDto createTransactions(@RequestBody List<TransactionDto> transactionDtoList) {
        return transactionService.saveTransactions(transactionDtoList);
    }

    @GetMapping("/accounts/{ownAccountNumber}/transactions")
    public List<TransactionDto> getAccountTransactions(@PathVariable String ownAccountNumber) {
        return transactionService.fetchAccountTransactions(ownAccountNumber);
    }

    @GetMapping("/trxTypes/{code}/transactions")
    public List<TransactionDto> getTrxTypeTransactions(@PathVariable Integer code) {
        return transactionService.fetchTrxTypeTransactions(code);
    }

    @GetMapping("/statements/{number}/transactions")
    public List<TransactionDto> getStatementTransactions(@PathVariable String number) {
        return transactionService.fetchStatementTransactions(number);
    }

    @GetMapping("/counterPartyAccounts/{number}/transactions")
    public List<TransactionDto> getCounterPartyAccountTransactions(@PathVariable String number) {
        return transactionService.fetchCounterPartyAccountTransactions(number);
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
