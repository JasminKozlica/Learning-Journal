package com.example.demo;


import jakarta.persistence.*;
import lombok.*;


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
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @Column(name = "userrole")
    @Enumerated(EnumType.STRING)
    private RoleName role;


}
