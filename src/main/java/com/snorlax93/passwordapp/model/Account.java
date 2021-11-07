package com.snorlax93.passwordapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aid_generator")
    @SequenceGenerator(name="aid_generator", sequenceName = "aid_next_val", allocationSize=1)
    private Long aid;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "factorauth")
    private String factorauth;

    @Column(name = "owner")
    private Long owner;

    // getter & setters
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
