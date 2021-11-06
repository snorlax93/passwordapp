package com.snorlaxx.passwordapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Account {

    private @Id @GeneratedValue Long aid;
    private String account;
    private String password;
    private String factorauth;
    private Long owner;

    private Account() {}

    public Account(String account, String password, String factorauth, Long owner) {
        this.account = account;
        this.password = password;
        this.factorauth = factorauth;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(aid, account.aid) &&
                Objects.equals(account, account.account) &&
                Objects.equals(password, account.password) &&
                Objects.equals(factorauth, account.factorauth) &&
                Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, account, password, factorauth, owner);
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFactorauth() {
        return factorauth;
    }

    public void setFactorauth(String factorauth) {
        this.factorauth = factorauth;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }
}
