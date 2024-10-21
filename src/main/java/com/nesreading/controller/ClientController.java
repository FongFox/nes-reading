package com.nesreading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClientController {
    @GetMapping("/home")
    public String getHomePage() {
        return "client/home";
    }

    @GetMapping("/shop")
    public String getShopPage() {
        return "client/shop";
    }

    @GetMapping("/single-product")
    public String getSingleProductPage() {
        return "client/single-product";
    }

    
}
