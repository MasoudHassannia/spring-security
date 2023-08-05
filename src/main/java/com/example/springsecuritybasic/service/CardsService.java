package com.example.springsecuritybasic.service;

import com.example.springsecuritybasic.model.Cards;
import com.example.springsecuritybasic.repository.CardsRepository;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CardsService {

    @Autowired
    private CardsRepository cardsRepository;


    public List<Cards> findByCustomerId(int customerId){
        return cardsRepository.findByCustomerId(customerId);
    }
}
