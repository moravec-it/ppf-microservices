package org.ppf.model.entity;

import java.math.BigDecimal;

public class TransactionAmount {

    private BigDecimal amount;
    private String creditDebitIndicator;
    private String currency;

    public TransactionAmount(BigDecimal amount, String creditDebitIndicator, String currency) {
        this.amount = amount;
        this.creditDebitIndicator = creditDebitIndicator;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public String getCurrency() {
        return currency;
    }
}
