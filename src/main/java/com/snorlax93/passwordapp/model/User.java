package com.snorlax93.passwordapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uid_generator") 
    @SequenceGenerator(name="uid_generator", sequenceName = "uid_next_val", allocationSize=1)
    private Long uid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "usergroup")
    private Integer usergroup;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Integer usergroup) {
        this.usergroup = usergroup;
    }

    
}
