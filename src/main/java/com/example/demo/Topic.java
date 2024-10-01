package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
@Data
@Builder

public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assigmentId")
    private Long assigmentId;
    @Column(name = "topicName")
    private String topicName;
    @Column(name = "assigmentDate")
    private Date assigmentDate;
    @Column(name = "dueDate")
    private Date dueDate;
    @Column(name = "status")
    private boolean status;
}
