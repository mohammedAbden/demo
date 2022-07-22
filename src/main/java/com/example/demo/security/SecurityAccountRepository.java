package com.example.demo.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityAccountRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUserName(String userName);

}
