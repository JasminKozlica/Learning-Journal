package com.example.demo.indexSite;

import com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Long> {
    List<Journal> findByCategory(String category);
    List<Journal> findByDate(LocalDate date);
    List<Journal> findByTags(String tags);
    List<Journal> findByUser(User user);
}

