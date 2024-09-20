package com.example.demo;
import jakarta.persistence.*;
import lombok.*;


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
    private Long id;
    private String title;
    private String content;
    private String category;
    private String tags;

}

