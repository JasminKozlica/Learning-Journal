package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name="journal")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Journal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryid")
    private Long entryId;
    @Column(name = "datum")
    private LocalDate date;
    @Column(name = "content")
    private String content;
    @Column(name = "category")
    private String category;
    @Column(name = "tags")
    private String tags;

}
