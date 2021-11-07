package com.snorlax93.passwordapp.controller;

import com.snorlax93.passwordapp.model.Log;
import com.snorlax93.passwordapp.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogController {
    
    @Autowired
    private LogService logService;

    @GetMapping("/log")
    public String logIndex(Model model) {
        model.addAttribute("logs", logService.getAllLogs());
        return "logIndex";
    }

    @GetMapping("/log/new")
    public String newLog(Model model) {
        Log log = new Log();
        model.addAttribute("log", log);
        return "newLogForm";
    }

    @PostMapping("/log/save")
    public String saveLog(@ModelAttribute("log") Log log, Model model) {
        logService.saveLog(log);
        model.addAttribute("log", log);
        return "newLogConfirm";
    }
    
    @GetMapping("/log/{lid}/update")
    public String updateLog(@PathVariable(value = "lid") long lid, Model model) {
        Log log = logService.getLogById(lid);
        model.addAttribute("log", log);
        return "updateLogForm";
    }

    @GetMapping("/log/{lid}/delete")
    public String deleteLog(@PathVariable(value = "lid") long lid, Model model) {
        Log log = this.logService.getLogById(lid);
        this.logService.deleteLogById(lid);
        model.addAttribute("log", log);
        return "deleteLogConfirm";
    }
}
