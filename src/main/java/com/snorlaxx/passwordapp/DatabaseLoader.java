package com.snorlaxx.passwordapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DatabaseLoader implements CommandLineRunner {

    private UserRepository userDB;
    private AccountRepository actDB;
    private LogsRepository logDB;

    @Autowired
    public DatabaseLoader(UserRepository userDB, AccountRepository actDB, LogsRepository logDB) {
        this.userDB = userDB;
        this.actDB = actDB;
        this.logDB = logDB;
    }

    @Override
    public void run(String... strings) throws  Exception {
        this.userDB.save(new User("test1@email.com", "password1", 0));
        this.userDB.save(new User("test2@email.com", "password1", 1));
        this.userDB.save(new User("test3@email.com", "password1", 2));
        this.userDB.save(new User("test3@email.com", "password1", 3));
        this.actDB.save(new Account("kohls", "kohlspassword", "6146689461", 15000000000L));
        this.actDB.save(new Account("nike", "nikepassword", "6146689462", 15000000001L));
        this.actDB.save(new Account("adidas", "adidaspassword", "6146689463", 15000000002L));
        this.actDB.save(new Account("underarmor", "underarmorpassword", "6146689464", 15000000003L));
        this.actDB.save(new Account("krogers", "krogerspassword", "6146689465", 15000000004L));
        this.logDB.save(new Log(15000000001L, "Something is happening"));
        this.logDB.save(new Log(15000000002L, "That's why we're logging it"));
        this.logDB.save(new Log(15000000003L, "Aren't you excited"));
    }
}
