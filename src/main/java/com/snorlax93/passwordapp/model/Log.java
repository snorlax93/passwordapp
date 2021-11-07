package com.snorlax93.passwordapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lid_generator") 
    @SequenceGenerator(name="lid_generator", sequenceName = "lid_next_val", allocationSize=1)
    private Long lid;

    @Column(name = "uid")
    private Long uid;

    @Column(name = "transaction")
    private String transaction;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
