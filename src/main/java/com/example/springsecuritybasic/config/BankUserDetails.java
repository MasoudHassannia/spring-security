package com.example.springsecuritybasic.config;

import com.example.springsecuritybasic.model.Customer;
import com.example.springsecuritybasic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String username, password = null;
        List<GrantedAuthority>  authorities = new ArrayList<>();
        List<Customer> customers = customerRepository.findByEmail(email);
        if(customers.isEmpty())
            throw new UsernameNotFoundException("User not found for the email: " + email);
        else{
            username = customers.get(0).getEmail();
            password = customers.get(0).getPwd();
            authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        }
        return new User(username,password,authorities);
    }
}
