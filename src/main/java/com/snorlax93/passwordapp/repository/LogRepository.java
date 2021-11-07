package com.snorlax93.passwordapp.repository;

import com.snorlax93.passwordapp.model.Log;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long>{
    
}
