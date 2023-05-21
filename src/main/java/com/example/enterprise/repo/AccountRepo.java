package com.example.enterprise.repo;

import com.example.enterprise.model.Account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

	Optional<Account> findByUsernameAndPassword(String username, String password);
}
