package com.example.enterprise.controller;

import com.example.enterprise.model.Account;
import com.example.enterprise.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountRepo.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getGearVbByID(@PathVariable String id) {
        Optional<Account> accountOptional= accountRepo.findById(id);
        return accountOptional.orElse(null);
    }
}
