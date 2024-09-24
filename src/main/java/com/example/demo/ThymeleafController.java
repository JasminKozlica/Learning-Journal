package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ThymeleafController {
    private final JournalService journalService;
    public ThymeleafController(JournalService journalService){
        this.journalService=journalService;
    }

    @GetMapping("/")
    public String getJournal(Model model){
        model.addAttribute("journal",new Journal());
            return "indexSite";
        }
        @PostMapping("/")
    public String submitJournalForm(@ModelAttribute Journal journal,Model model){
            journalService.insertEntry(journal);
        model.addAttribute("journal",journal);
        return "confirmation";
        }

    @GetMapping("/allJournals")
    public String getAllJournals(Model model){
        List<Journal>journalEntries=journalService.getAllJournalEntries();
        model.addAttribute("journals",journalEntries);
        return "allJournalEntries";
    }
    }


