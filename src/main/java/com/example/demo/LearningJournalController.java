package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LearningJournalController {

    @Autowired
    private final JournalService journalService;

    public LearningJournalController(JournalService journalService) {
        this.journalService = journalService;
    }

   @GetMapping(value = "/journal")
   @ResponseBody
    public List<Journal> getJournal() {
       return journalService.getAllJournalEntries();
   }

}

