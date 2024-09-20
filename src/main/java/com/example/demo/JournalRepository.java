package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JournalRepository extends JpaRepository<JournalEntry,Long> {
    List<Journal>findByCategory(String category);
    Optional<Journal> findById(Long entryId);
}
