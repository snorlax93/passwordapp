package com.snorlax93.passwordapp.service;

import java.util.List;

import com.snorlax93.passwordapp.model.Log;

public interface LogService {
    List<Log> getAllLogs();
    void saveLog(Log log);
    Log getLogById(long lid);
    void deleteLogById(long lid);
}
