package com.example.demo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Role;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleName role;


}
