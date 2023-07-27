package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.Customer;
import com.example.springsecuritybasic.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){

        ResponseEntity responseEntity = null;

        try{
            Customer newCustomer = customerService.save(customer);
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

}
