package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Accounts;
import com.example.springsecuritybasic.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountsRepository accountsRepository;


    public Accounts findByCustomerId(int customerId){
        return accountsRepository.findByCustomerId(customerId);
    }

}
