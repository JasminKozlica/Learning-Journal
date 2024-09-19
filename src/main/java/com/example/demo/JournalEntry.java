package com.example.demo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JournalEntry {
    @Id
            @GeneratedValue(strategy= GenerationType.IDENTITY)
            @Column(name = "id")
    Integer entryId ;
    LocalDate date;
    String content;
    String tags;

}

