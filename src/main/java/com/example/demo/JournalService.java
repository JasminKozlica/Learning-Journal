package com.example.demo;

import com.example.demo.JournalEntry;
import com.example.demo.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    public Journal createJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public Optional<Journal> getEntryById(Long id) {
        return journalRepository.findById(id);
    }

    public Journal updateEntry(Long id, Journal updatedEntry) {
        updatedEntry.setEntryId(id);
        return journalRepository.save(updatedEntry);
    }

    public void deleteEntry(Long id) {
        JournalRepository.deleteById(id);

    }

    public List<Journal> getAllEntries() {
        return journalRepository.findAll();
    }
}