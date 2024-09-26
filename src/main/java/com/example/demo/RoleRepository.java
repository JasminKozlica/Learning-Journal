package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository <RoleName, Long> {

    Optional<Object> findByUserName(RoleName roleName);

}
