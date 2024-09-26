package com.example.demo.indexSite;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ThymeleafController {
    private final JournalService journalService;

    public ThymeleafController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/")
    public String getJournal(Model model) {
        model.addAttribute("journal", new Journal());
        return "indexSite";
    }

    @PostMapping("/")
    public String submitJournalForm(@ModelAttribute Journal journal, Model model) {
        journalService.insertEntry(journal);
        model.addAttribute("journal", journal);
        return "confirmation";
    }

    @GetMapping("/journals") // /journals
    public String getAllJournals(Model model) {
        List<Journal> journalEntries = journalService.getAllJournalEntries();
        model.addAttribute("journals", journalEntries);
        return "allJournalEntries";
    }

    @DeleteMapping("/journals/{id}") // /journals/{id}
    public String deleteEntry(@PathVariable Long id){
        journalService.deleteEntry(id);
        return "redirect:/journals";
    }

    @PutMapping("/journals/{id}") // /journals/{id}
    public String updateEntry(@PathVariable Long id, @ModelAttribute Journal updatedJournal, Model model){
        journalService.updateJournal(id,updatedJournal);
        return "redirect:/journals";
    }

    @GetMapping("/journals/{id}")
    public String getJournal(@PathVariable Long id,Model model){
        model.addAttribute("journal", journalService.getJournalById(id));
        return "journalUpdateSite";
    }

}


