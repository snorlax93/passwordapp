package com.snorlax93.passwordapp.controller;

import com.snorlax93.passwordapp.model.Account;
import com.snorlax93.passwordapp.model.Log;
import com.snorlax93.passwordapp.service.AccountService;
import com.snorlax93.passwordapp.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Random;

@Controller
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private LogService logService;
    private Random random = new Random();

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/account")
    public String accountIndex(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "accountIndex";
    }

    @GetMapping("/account/new")
    public String newAccount(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "newAccountForm";
    }

    @PostMapping("/account/save")
    public String saveAccount(@ModelAttribute("account") Account account, Model model) {
        accountService.saveAccount(account);
        model.addAttribute("account", account);
        Log log = new Log();
        log.setUid(random.nextLong());
        log.setTransaction("a new account was added :: " + account);
        logService.saveLog(log);
        return "newAccountConfirm";
    }

    @GetMapping("/account/{aid}/update")
    public String updateAccount(@PathVariable(value = "aid") long aid, Model model) {
        Account account = accountService.getAccountById(aid);
        model.addAttribute("account", account);
        Log log = new Log();
        log.setUid(random.nextLong());
        log.setTransaction("an account was updated :: " + account);
        logService.saveLog(log);
        return "updateAccountForm";
    }

    @GetMapping("/account/{aid}/delete")
    public String deleteAccount(@PathVariable(value = "aid") long aid, Model model) {
        Account account = this.accountService.getAccountById(aid);
        this.accountService.deleteAccountById(aid);
        model.addAttribute("account", account);
        Log log = new Log();
        log.setUid(random.nextLong());
        log.setTransaction("an account was deleted :: " + account);
        logService.saveLog(log);
        return "deleteAccountConfirm";
    }
}
