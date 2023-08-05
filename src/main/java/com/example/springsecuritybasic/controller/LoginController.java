package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.Customer;
import com.example.springsecuritybasic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

        ResponseEntity responseEntity = null;

        try{
            customer.setPwd(passwordEncoder.encode(customer.getPwd()));
            customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
            Customer newCustomer  = customerService.save(customer);
            if(newCustomer.getId() > 0)
                responseEntity = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("new User successfully registered");
        }catch (Exception ex){
            responseEntity = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception accured due to "+ ex.getMessage());
        }
        return responseEntity;
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication){
        List<Customer> customerList = customerService.findByEmail(authentication.getName());
        if(!customerList.isEmpty())
            return customerList.get(0);
        else return null;
    }

}
