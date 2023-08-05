package com.example.springsecuritybasic.controller;

import com.example.springsecuritybasic.model.Cards;
import com.example.springsecuritybasic.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsService cardsService;


    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id) {
        List<Cards> cardsList = cardsService.findByCustomerId(id);
        if(!cardsList.isEmpty())
            return cardsList;
        else
            return null;
    }

}