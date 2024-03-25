package org.ppf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(schema="public", name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="`trxId`")
    private Long trxId;

    @ManyToOne
    @JoinColumn(name="`statement`")
    private Statement statement;

    @ManyToOne
    @JoinColumn(name="`counterPartyAccount`")
    private Account counterPartyAccount;

    @ManyToOne
    @JoinColumn(name="`transactionType`")
    private TransactionType transactionType;

    @Column
    private BigDecimal amount;

    @Column
    private String currency;

    @Column
    private String id;

    @Column
    private String bankref;

    @Column(name="`transactionId`")
    private String transactionId;

    @Column(name="`bookingDate`")
    private Date bookingDate;

    @Column(name="`postingDate`")
    private Date postingDate;

    @Column(name="`creditDebitIndicator`")
    private String creditDebitIndicator;

    @Column(name="`ownAccountNumber`")
    private String ownAccountNumber;

    @Column
    private String detail1;

    @Column
    private String detail2;

    @Column
    private String detail3;

    @Column
    private String detail4;

    @Column(name="`productBankRef`")
    private String productBankRef;

    @Column(name="`constantSymbol`")
    private String constantSymbol;

    @Column(name="`specificSymbol`")
    private String specificSymbol;

    @Column(name="`variableSymbol`")
    private String variableSymbol;

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Account getCounterPartyAccount() {
        return counterPartyAccount;
    }

    public void setCounterPartyAccount(Account counterPartyAccount) {
        this.counterPartyAccount = counterPartyAccount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankref() {
        return bankref;
    }

    public void setBankref(String bankref) {
        this.bankref = bankref;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public String getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(String creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public String getOwnAccountNumber() {
        return ownAccountNumber;
    }

    public void setOwnAccountNumber(String ownAccountNumber) {
        this.ownAccountNumber = ownAccountNumber;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }

    public String getDetail4() {
        return detail4;
    }

    public void setDetail4(String detail4) {
        this.detail4 = detail4;
    }

    public String getProductBankRef() {
        return productBankRef;
    }

    public void setProductBankRef(String productBankRef) {
        this.productBankRef = productBankRef;
    }

    public String getConstantSymbol() {
        return constantSymbol;
    }

    public void setConstantSymbol(String constantSymbol) {
        this.constantSymbol = constantSymbol;
    }

    public String getSpecificSymbol() {
        return specificSymbol;
    }

    public void setSpecificSymbol(String specificSymbol) {
        this.specificSymbol = specificSymbol;
    }

    public String getVariableSymbol() {
        return variableSymbol;
    }

    public void setVariableSymbol(String variableSymbol) {
        this.variableSymbol = variableSymbol;
    }
}
