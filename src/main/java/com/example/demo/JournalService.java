package com.example.demo;

import com.example.demo.JournalEntry;
import com.example.demo.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    public JournalEntry createJournalEntry(JournalEntry journal){
        return journalRepository.save(journal);
    }

    public Optional<JournalEntry> getEntryById(Long id);{
        return journalRepository.findById(id);
    }
    public JournalEntry updateEntry(Long id,JournalEntry updatedEntry){
        updatedEntry.setId(id);
        return journalRepository.save(updatedEntry);
    }

public void deleteEntry(Long id){
    JournalRepository.deleteById(id);

}
public List<JournalEntry> getAllEntries() {
    return journalRepository.findAll();
}
}