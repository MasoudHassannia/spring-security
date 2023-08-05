package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Loans;
import com.example.springsecuritybasic.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId){
        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
}
