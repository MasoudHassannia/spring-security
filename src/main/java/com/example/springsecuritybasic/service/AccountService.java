package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Accounts;
import com.example.springsecuritybasic.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

    @Autowired
    private AccountsRepository accountsRepository;


    public Accounts findByCustomerId(int customerId){
        return accountsRepository.findByCustomerId(customerId);
    }

}
