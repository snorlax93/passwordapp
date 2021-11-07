package com.snorlax93.passwordapp.controller;

import com.snorlax93.passwordapp.model.Account;
import com.snorlax93.passwordapp.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public String account(Model model) {
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
    public String saveAccount(@ModelAttribute("account") Account account) {
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/account/{aid}/update")
    public String updateAccount(@PathVariable(value = "aid") long aid, Model model) {
        Account account = accountService.getAccountById(aid);
        model.addAttribute("account", account);
        return "updateAccountForm";
    }

    @GetMapping("/account/{aid}/delete")
    public String deleteAccount(@PathVariable(value = "aid") long aid) {
        this.accountService.deleteAccountById(aid);
        return "redirect:/";
    }
}
