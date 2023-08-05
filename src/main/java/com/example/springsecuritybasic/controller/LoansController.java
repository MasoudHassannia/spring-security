package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.Loans;
import com.example.springsecuritybasic.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanService loanService;


    @GetMapping("/myLoans")
    public List<Loans>  getLoanDetails(@RequestParam int id) {
        List<Loans> loansList = loanService.findByCustomerIdOrderByStartDtDesc(id);
        if(!loansList.isEmpty())
            return loansList;
        else return null;
    }
}
