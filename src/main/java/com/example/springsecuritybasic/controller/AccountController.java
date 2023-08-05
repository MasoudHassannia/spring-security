package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.Accounts;
import com.example.springsecuritybasic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountService.findByCustomerId(id);
        if(accounts != null)
            return accounts;
        else
            return null;
    }
}
