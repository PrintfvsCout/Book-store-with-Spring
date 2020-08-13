package com.example.EMTProdKniga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@Controller
public class HomeController
{
    @GetMapping("/")
    public String getHome()
    {
        return "home";
    }
}
