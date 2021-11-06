package com.snorlaxx.passwordapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.util.Objects;

@Entity
public class Log {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lid_generator") 
    @SequenceGenerator(name="lid_generator", sequenceName = "lid_seq", allocationSize=1)
    private Long lid;
    private Long uid;
    private String transaction;

    private Log() {}

    public Log(Long uid, String transaction) {
        this.uid = uid;
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log logs = (Log) o;
        return Objects.equals(lid, logs.lid) &&
                Objects.equals(uid, logs.uid) &&
                Objects.equals(transaction, logs.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lid, uid, transaction);
    }

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
