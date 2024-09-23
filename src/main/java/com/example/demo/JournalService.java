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


    public List<Journal> getAllJournalEntries() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(Long entryId) {
        return Optional.ofNullable(journalRepository.findById(entryId)
                .orElseThrow(() -> new RuntimeException("Journal entry not found with id: " + entryId)));
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
    public void deleteEntry(Long id) {
        journalRepository.deleteById(id);
    }

}
