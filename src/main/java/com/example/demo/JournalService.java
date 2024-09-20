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


    public Journal createJournal(Journal journal) {
//        journal.setDate(LocalDate.now());
        return journalRepository.save(journal);
    }

    public List<Journal> getAllJournals() {
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

    public Journal updateJournal(Journal updatedJournal) {
        if (journalRepository.existsById(updatedJournal.getEntryId())) {
            return journalRepository.save(updatedJournal);
        } else {
            throw new RuntimeException("Journal not found");
        }
    }

    public void deleteJournal(Long entryId){
        journalRepository.deleteById(entryId);
    }
}
