package com.example.demo;

import com.example.demo.JournalEntry;
import com.example.demo.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;


    public Journal createJournalEntry(Journal journal) {
//        journal.setDate(LocalDate.now());
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

    public Optional<Journal> getJournalById(Long entryId) {
        return journalRepository.findById(entryId);
    }

    public List<Journal> getJournalByCategory(String category) {
        return journalRepository.findByCategory(category);
    }

    public List<Journal> getJournalByDate(LocalDate date) {
        return journalRepository.findByDate(date);
    }

    public List<Journal> findByTags(String tags) {
        return journalRepository.findByTags(tags);
    }

    public Journal updateJournal(Long entryId, Journal updatedJournal) {
        return journalRepository.findById(entryId)
                .map(journal -> {
                    journal.setCategory(updatedJournal.getCategory());
                    journal.setDate(updatedJournal.getDate());
                    journal.setTags(updatedJournal.getTags());
                    return journalRepository.save(journal);
                })
                .orElseThrow(() -> new RuntimeException("Journal not found"));
    }

    public void deleteJournal(Long entryId){
        journalRepository.deleteById(entryId);
    }
}
