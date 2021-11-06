package com.snorlaxx.passwordapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.util.Objects;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uid_generator") 
    @SequenceGenerator(name="uid_generator", sequenceName = "uid_seq", allocationSize=1)
    private Long uid;
    private String username;
    private String password;
    private Integer usergroup;

    private User() {
    }

    public User(String username, String password, Integer usergroup) {
        this.username = username;
        this.password = password;
        this.usergroup = usergroup;
    }

    public Long getUid() {
        return uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(usergroup, user.usergroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password, usergroup);
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
