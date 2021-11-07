package com.snorlax93.passwordapp.service.impl;

import java.util.List;
import java.util.Optional;

import com.snorlax93.passwordapp.model.Log;
import com.snorlax93.passwordapp.repository.LogRepository;
import com.snorlax93.passwordapp.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{
    
    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public void saveLog(Log log) {
        this.logRepository.save(log);
        
    }

    @Override
    public Log getLogById(long lid) {
        Optional<Log> optional = logRepository.findById(lid);
        Log log = null;
        if(optional.isPresent()) {
            log = optional.get();
        } else {
            throw new RuntimeException(" Log not found for id :: " + lid);
        }
        return log;
    }

    @Override
    public void deleteLogById(long lid) {
        this.logRepository.deleteById(lid);
        
    }
}
