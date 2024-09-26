package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "role")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName name ;
}
