package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Cards;
import com.example.springsecuritybasic.repository.CardsRepository;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {

    @Autowired
    private CardsRepository cardsRepository;


    public List<Cards> findByCustomerId(int customerId){
        return cardsRepository.findByCustomerId(customerId);
    }
}
