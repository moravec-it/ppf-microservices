package org.ppf.api.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionSaveLogDto {

    private final List<AccountDto> createdAccounts;
    private final List<StatementDto> createdStatements;
    private final List<TransactionTypeDto> createdTransactionTypes;

    private final Set<AccountDto> referencedAccountsWithIgnoredContent;
    private final Set<StatementDto> referencedStatementsWithIgnoredContent;
    private final Set<TransactionTypeDto> referencedTransactionTypesWithIgnoredContent;

    public TransactionSaveLogDto() {
        createdAccounts = new ArrayList<>();
        createdStatements = new ArrayList<>();
        createdTransactionTypes = new ArrayList<>();
        referencedAccountsWithIgnoredContent = new HashSet<>();
        referencedStatementsWithIgnoredContent = new HashSet<>();
        referencedTransactionTypesWithIgnoredContent = new HashSet<>();
    }

    public List<AccountDto> getCreatedAccounts() {
        return createdAccounts;
    }

    public List<StatementDto> getCreatedStatements() {
        return createdStatements;
    }

    public List<TransactionTypeDto> getCreatedTransactionTypes() {
        return createdTransactionTypes;
    }

    public Set<AccountDto> getReferencedAccountsWithIgnoredContent() {
        return referencedAccountsWithIgnoredContent;
    }

    public Set<StatementDto> getReferencedStatementsWithIgnoredContent() {
        return referencedStatementsWithIgnoredContent;
    }

    public Set<TransactionTypeDto> getReferencedTransactionTypesWithIgnoredContent() {
        return referencedTransactionTypesWithIgnoredContent;
    }
}
