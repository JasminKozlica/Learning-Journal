package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/")
    public String getJournal(Model model){
        model.addAttribute("journal",new Journal());
            return "indexSite.html";
        }
    }


