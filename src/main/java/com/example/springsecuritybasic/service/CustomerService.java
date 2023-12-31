package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Customer;
import com.example.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
       return customerRepository.save(customer);
    }

    public List<Customer> findByEmail(String email){
        return customerRepository.findByEmail(email);
    }
}
