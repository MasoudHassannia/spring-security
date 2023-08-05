package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.AccountTransactions;
import com.example.springsecuritybasic.service.AccountTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsService accountTransactionsService;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactionsList =
                accountTransactionsService.findByCustomerIdOrderByTransactionDtDesc(id);

        if(!accountTransactionsList.isEmpty())
            return accountTransactionsList;
        else
            return null;
    }
}