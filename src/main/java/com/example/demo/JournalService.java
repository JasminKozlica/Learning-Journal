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
//        journal.setDate(LocalDate.now());
        return journalRepository.save(journal);
    }

<<<<<<< HEAD
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
=======
    public Optional<Journal> getEntryById(Long id) {
        return journalRepository.findById(id);
    }

    public Journal updateEntry(Long id, Journal updatedEntry) {
        updatedEntry.setEntryId(id);
        return journalRepository.save(updatedEntry);
    }

    public void deleteEntry(Long id) {
        journalRepository.deleteById(id);
    }

    public List<Journal> getAllEntries() {
        return journalRepository.findAll();
    }
>>>>>>> 2b039ca (jurnal Controller added,datenbank user and journal added,code clean)
}
