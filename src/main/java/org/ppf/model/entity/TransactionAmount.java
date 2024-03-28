package org.ppf.model.entity;

import java.math.BigDecimal;

public class TransactionAmount {

    private BigDecimal amount;
    private String currency;

    public TransactionAmount(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
