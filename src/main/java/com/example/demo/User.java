package com.example.demo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Role;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "appuser")
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
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email")
    private String email;
//    @Column(name = "feedback")
//    private String feedback;
    @Column(name = "userrole",nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleName role;


}
