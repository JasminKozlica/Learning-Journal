package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;


    public Journal createJournalEntry(Journal journal) {
      journal.setDate(LocalDate.now());
        return journalRepository.save(journal);
    }

    public Optional<Journal> getEntryById(Long id) {
        return journalRepository.findById(id);
    }

    public Journal updateEntry(Long id, Journal updatedEntry) {
        updatedEntry.setId(id);
        return journalRepository.save(updatedEntry);
    }

    public void deleteEntry(Long id) {
        journalRepository.deleteById(id);

    }

    public List<Journal> getAllEntries() {
        return journalRepository.findAll();
    }
}
