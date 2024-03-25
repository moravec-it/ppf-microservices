package org.ppf.api.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class TransactionDto {

    private Amount amount;
    private String bankref;
    private Date bookingDate;
    private CounterPartyAccount counterPartyAccount;
    private String creditDebitIndicator;
    private Details details;
    private String id;
    private String ownAccountNumber;
    private Date postingDate;
    private String productBankRef;
    private String statementNumber;
    private String statementPeriod;
    private String statementDescription;
    private String transactionId;
    private String transactionType;
    private Integer transactionTypeCode;
    private String variableSymbol;
    private String constantSymbol;
    private String specificSymbol;

    public Amount getAmount() {
        return amount;
    }

    public String getBankref() {
        return bankref;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public CounterPartyAccount getCounterPartyAccount() {
        return counterPartyAccount;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public Details getDetails() {
        return details;
    }

    public String getId() {
        return id;
    }

    public String getOwnAccountNumber() {
        return ownAccountNumber;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public String getProductBankRef() {
        return productBankRef;
    }

    public String getSpecificSymbol() {
        return specificSymbol;
    }

    public String getStatementNumber() {
        return statementNumber;
    }

    public String getStatementPeriod() {
        return statementPeriod;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Integer getTransactionTypeCode() {
        return transactionTypeCode;
    }

    public String getVariableSymbol() {
        return variableSymbol;
    }

    public String getConstantSymbol() {
        return constantSymbol;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public void setBankref(String bankref) {
        this.bankref = bankref;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setCounterPartyAccount(CounterPartyAccount counterPartyAccount) {
        this.counterPartyAccount = counterPartyAccount;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwnAccountNumber(String ownAccountNumber) {
        this.ownAccountNumber = ownAccountNumber;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public void setProductBankRef(String productBankRef) {
        this.productBankRef = productBankRef;
    }

    public void setStatementNumber(String statementNumber) {
        this.statementNumber = statementNumber;
    }

    public void setStatementPeriod(String statementPeriod) {
        this.statementPeriod = statementPeriod;
    }

    public void setStatementDescription(String statementDescription) {
        this.statementDescription = statementDescription;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setTransactionTypeCode(Integer transactionTypeCode) {
        this.transactionTypeCode = transactionTypeCode;
    }

    public void setVariableSymbol(String variableSymbol) {
        this.variableSymbol = variableSymbol;
    }

    public void setConstantSymbol(String constantSymbol) {
        this.constantSymbol = constantSymbol;
    }

    public void setSpecificSymbol(String specificSymbol) {
        this.specificSymbol = specificSymbol;
    }

    public static class Amount {

        private BigDecimal value;
        private String currency;

        public BigDecimal getValue() {
            return value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public static class CounterPartyAccount {

        private String accountName;
        private String accountNumber;
        private String bankCode;

        public String getAccountName() {
            return accountName;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }
    }

    public static class Details {

        private String detail1;
        private String detail2;
        private String detail3;
        private String detail4;

        public String getDetail1() {
            return detail1;
        }

        public String getDetail2() {
            return detail2;
        }

        public String getDetail3() {
            return detail3;
        }

        public String getDetail4() {
            return detail4;
        }

        public void setDetail1(String detail1) {
            this.detail1 = detail1;
        }

        public void setDetail2(String detail2) {
            this.detail2 = detail2;
        }

        public void setDetail3(String detail3) {
            this.detail3 = detail3;
        }

        public void setDetail4(String detail4) {
            this.detail4 = detail4;
        }
    }
}