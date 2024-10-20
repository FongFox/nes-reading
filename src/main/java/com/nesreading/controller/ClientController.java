package com.nesreading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClientController {
    @GetMapping("/")
    public String getHomePage() {
        return "client/home";
    }

    @GetMapping("/shop")
    public String getShopPage() {
        return "client/shop";
    }
    
}
