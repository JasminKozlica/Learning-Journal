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
    Optional<User> findByUsername(String username);
=======
    List<User> findAll();
    Optional<User> findUserById(Long id);
    Optional<User> findByUsername(String username);

    User findByEmail(String email);


//
//    List<User> findByLastName(String lastName);
//
//    User findByUsernameAndPassword(String username, String password);
>>>>>>> b4d8b1a360012783ee10b0643241cbb880fe64bf
}
