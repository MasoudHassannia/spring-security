package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.AccountTransactions;
import com.example.springsecuritybasic.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTransactionsService {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    public List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId){
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
    }
}
