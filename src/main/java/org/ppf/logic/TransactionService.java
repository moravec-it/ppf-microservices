package org.ppf.logic;

import org.ppf.api.dto.TransactionDto;
import org.ppf.model.dao.AccountDao;
import org.ppf.model.dao.StatementDao;
import org.ppf.model.dao.TransactionDao;
import org.ppf.model.dao.TransactionTypeDao;
import org.ppf.model.entity.Account;
import org.ppf.model.entity.Statement;
import org.ppf.model.entity.Transaction;
import org.ppf.model.entity.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private StatementDao statementDao;
    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private TransactionTypeDao transactionTypeDao;

    @Transactional
    public List<TransactionDto> fetchAccountTransactions(String ownAccountNumber) {
        List<Transaction> transactions = transactionDao.findByOwnAccountNumber(ownAccountNumber);
        return transactions.stream().map(transaction -> {

            TransactionDto transactionDto = new TransactionDto();

            TransactionDto.Amount amount = new TransactionDto.Amount();
            amount.setValue(transaction.getAmount());
            amount.setCurrency(transaction.getCurrency());

            transactionDto.setAmount(amount);
            transactionDto.setBankref(transaction.getBankref());
            transactionDto.setBookingDate(transaction.getBookingDate());
            transactionDto.setConstantSymbol(transaction.getConstantSymbol());
            transactionDto.setVariableSymbol(transaction.getVariableSymbol());
            transactionDto.setSpecificSymbol(transaction.getSpecificSymbol());

            TransactionDto.CounterPartyAccount account = new TransactionDto.CounterPartyAccount();
            account.setAccountName(transaction.getCounterPartyAccount().getName());
            account.setAccountNumber(transaction.getCounterPartyAccount().getNumber());
            account.setBankCode(transaction.getCounterPartyAccount().getCode());

            transactionDto.setCounterPartyAccount(account);
            transactionDto.setCreditDebitIndicator(transaction.getCreditDebitIndicator());
            transactionDto.setId(transaction.getId());
            transactionDto.setOwnAccountNumber(transaction.getOwnAccountNumber());
            transactionDto.setProductBankRef(transaction.getProductBankRef());
            transactionDto.setPostingDate(transaction.getPostingDate());

            TransactionDto.Details details = new TransactionDto.Details();
            details.setDetail1(transaction.getDetail1());
            details.setDetail2(transaction.getDetail2());
            details.setDetail3(transaction.getDetail3());
            details.setDetail4(transaction.getDetail4());

            transactionDto.setDetails(details);
            transactionDto.setStatementDescription(transaction.getStatement().getDescription());
            transactionDto.setStatementNumber(transaction.getStatement().getNumber());
            transactionDto.setStatementPeriod(transaction.getStatement().getPeriod());
            transactionDto.setTransactionId(transaction.getTransactionId());
            transactionDto.setTransactionType(transaction.getTransactionType().getType());
            transactionDto.setTransactionTypeCode(transaction.getTransactionType().getCode());

            return transactionDto;

        }).collect(Collectors.toList());
    }

    @Transactional
    public void saveTransactions(List<TransactionDto> transactionDtoList) {
        for (TransactionDto transactionDto: transactionDtoList) {
            saveTransaction(transactionDto);
        }
    }

    @Transactional
    public void saveTransaction(TransactionDto transactionDto) {
        // Not the best solution, but fast enough to develop.
        Account account = accountDao.findByNumber(transactionDto.getCounterPartyAccount().getAccountNumber());
        Statement statement = statementDao.findByNumber(transactionDto.getStatementNumber());
        TransactionType transactionType = transactionTypeDao.findByCode(transactionDto.getTransactionTypeCode());

        if (account == null) {
            account = new Account();
            account.setCode(transactionDto.getCounterPartyAccount().getBankCode());
            account.setNumber(transactionDto.getCounterPartyAccount().getAccountNumber());
            account.setName(transactionDto.getCounterPartyAccount().getAccountName());
            accountDao.save(account);
        }
        if (statement == null) {
            statement = new Statement();
            statement.setNumber(transactionDto.getStatementNumber());
            statement.setPeriod(transactionDto.getStatementPeriod());
            statement.setDescription(transactionDto.getStatementDescription());
            statementDao.save(statement);
        }
        if (transactionType == null) {
            transactionType = new TransactionType();
            transactionType.setType(transactionDto.getTransactionType());
            transactionType.setCode(transactionDto.getTransactionTypeCode());
            transactionTypeDao.save(transactionType);
        }
        Transaction transaction = new Transaction();

        transaction.setCounterPartyAccount(account);
        transaction.setStatement(statement);
        transaction.setTransactionType(transactionType);

        transaction.setAmount(transactionDto.getAmount().getValue());
        transaction.setBankref(transactionDto.getBankref());
        transaction.setBookingDate(transactionDto.getBookingDate());
        transaction.setConstantSymbol(transactionDto.getConstantSymbol());
        transaction.setCounterPartyAccount(account);
        transaction.setCreditDebitIndicator(transactionDto.getCreditDebitIndicator());
        transaction.setCurrency(transactionDto.getAmount().getCurrency());
        transaction.setDetail1(transactionDto.getDetails().getDetail1());
        transaction.setDetail2(transactionDto.getDetails().getDetail2());
        transaction.setDetail3(transactionDto.getDetails().getDetail3());
        transaction.setDetail4(transactionDto.getDetails().getDetail4());
        transaction.setId(transactionDto.getId());
        transaction.setOwnAccountNumber(transactionDto.getOwnAccountNumber());
        transaction.setPostingDate(transactionDto.getPostingDate());
        transaction.setBookingDate(transactionDto.getBookingDate());
        transaction.setProductBankRef(transactionDto.getProductBankRef());
        transaction.setConstantSymbol(transactionDto.getConstantSymbol());
        transaction.setVariableSymbol(transactionDto.getVariableSymbol());
        transaction.setSpecificSymbol(transactionDto.getSpecificSymbol());
        transaction.setTransactionId(transactionDto.getTransactionId());
        transactionDao.save(transaction);
    }
}
