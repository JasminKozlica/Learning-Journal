package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journals")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping
    public Journal createJournal(@RequestBody Journal journal) {
        return journalService.createJournalEntry(journal);
    }

    @GetMapping("/{id}")
    public Optional<Journal> getEntryById(@PathVariable Long id) {
        return journalService.getJournalById(id);
    }

    @PutMapping("/{id}")
    public Journal updateEntry(@PathVariable Long id, @RequestBody Journal updatedEntry) {
        return journalService.updateJournal(id, updatedEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        journalService.deleteEntry(id);
    }

    @GetMapping
    public List<Journal> getAllEntries() {
        return journalService.getAllJournalEntries();
    }
}