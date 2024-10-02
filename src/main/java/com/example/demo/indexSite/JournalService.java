package com.example.demo.indexSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalService {




    @Autowired
    private JournalRepository journalRepository;


    public void insertEntry(Journal journal) {                                        //Create
       journal.setDate(LocalDate.now());
        journalRepository.save(journal);
    }


    public List<Journal> getAllJournalEntries() {
        return journalRepository.findAll();
    }   // Read

    public void updateJournal(Long entryId, Journal updatedJournal) {                 //Update
        journalRepository.findById(entryId)
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
    }               //Delete

    public Journal getJournalById(Long id){                                             //Find Journal eintrag nach dem id/button
    return journalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Journal not found"));
    }

}

