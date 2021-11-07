package com.snorlax93.passwordapp.repository;

import com.snorlax93.passwordapp.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
}
