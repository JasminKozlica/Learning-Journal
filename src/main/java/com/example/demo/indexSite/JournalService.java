package com.example.demo.indexSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalService {




    @Autowired
    private JournalRepository journalRepository;


    public Journal insertEntry(Journal journal) {                                        //Create
       journal.setDate(LocalDate.now());
        return journalRepository.save(journal);
    }


    public List<Journal> getAllJournalEntries() {
        return journalRepository.findAll();
    }   // Read

    public Journal updateJournal(Long entryId, Journal updatedJournal) {                 //Update
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
    }               //Delete

    public Journal getJournalById(Long id){                                             //Find Journal eintrag nach dem id/button
    return journalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Journal not found"));
    }

}
//    public Optional<Journal> getJournalById(Long entryId) {
//        return Optional.ofNullable(journalRepository.findById(entryId)
//                .orElseThrow(() -> new RuntimeException("Journal entry not found with id: " + entryId)));
//    }

//    public List<Journal> getJournalByCategory(String category) {
//        return journalRepository.findByCategory(category);
//    }
//
//    public List<Journal> getJournalByDate(LocalDate date) {
//        return journalRepository.findByDate(date);
//    }

// public List<Journal> findByTags(String tags) {
//   return journalRepository.findByTags(tags);
//}
