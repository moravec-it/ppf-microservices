package org.ppf.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="`transactionType`")
public class TransactionType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="`trxTypeId`")
    private Long trxTypeId;

    @Column
    private String type;

    @Column
    private Integer code;

    public Long getTrxTypeId() {
        return trxTypeId;
    }

    public void setTrxTypeId(Long trxTypeId) {
        this.trxTypeId = trxTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
