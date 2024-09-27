package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
    List<User> getAllUsers();
    Optional<User> findUserById(Long id);
=======
    Optional<User> findByUsername(String username);
>>>>>>> cfb6c39493d052e7c475db5c639b1a3718b89788
}
