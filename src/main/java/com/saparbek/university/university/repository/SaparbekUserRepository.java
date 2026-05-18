package com.saparbek.university.university.repository;

import com.saparbek.university.university.entity.SaparbekUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SaparbekUserRepository extends JpaRepository<SaparbekUser, Long> {
    Optional<SaparbekUser> findByUsername(String username);
    Optional<SaparbekUser> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}