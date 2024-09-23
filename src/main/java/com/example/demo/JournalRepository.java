package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Long> {
    List<Journal> findByCategory(String category);
    List<Journal> findByDate(LocalDate date);
    List<Journal> findByTags(String tags);
}
