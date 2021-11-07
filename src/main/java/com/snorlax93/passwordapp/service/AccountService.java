package com.snorlax93.passwordapp.service;

import java.util.List;

import com.snorlax93.passwordapp.model.Account;

public interface AccountService {
    List<Account> getAllAccounts();
    void saveAccount(Account account);
    Account getAccountById(long aid);
    void deleteAccountById(long aid);
}
