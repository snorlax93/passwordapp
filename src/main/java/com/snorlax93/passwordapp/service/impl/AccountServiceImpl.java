package com.snorlax93.passwordapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snorlax93.passwordapp.model.Account;
import com.snorlax93.passwordapp.repository.AccountRepository;
import com.snorlax93.passwordapp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(long aid) {
        Optional<Account> optional = accountRepository.findById(aid);
        Account account = null;
        if (optional.isPresent()) {
            account = optional.get();
        } else {
            throw new RuntimeException(" Account not found for id :: " + aid);
        }
        return account;
    }

    @Override
    public void deleteAccountById(long aid) {
        this.accountRepository.deleteById(aid);
        
    }
    
}
