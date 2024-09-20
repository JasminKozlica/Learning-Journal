package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Journal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryID")
    private Long entryId;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "content")
    private String content;
    @Column(name = "category")
    private String category;
    @Column(name = "tags")
    private String tags;

}
