package com.example.enterprise.controller;

import com.example.enterprise.model.Account;
import com.example.enterprise.model.Product;
import com.example.enterprise.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class AccountController {

	@Autowired
	AccountRepo accountRepo;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	@GetMapping("/accounts/{id}")
	public Account getAccountByID(@PathVariable String id) {
		Optional<Account> accountOptional = accountRepo.findById(id);
		return accountOptional.orElse(null);
	}

	@GetMapping("/accounts/{username}/{password}")
	public Account getAccountByUserNameAndPassword(@PathVariable String username, @PathVariable String password) {
		Optional<Account> accountOptional = accountRepo.findByUsernameAndPassword(username, password);
		return accountOptional.orElse(null);
	}


	@PostMapping("/accounts")
	public RedirectView createProduct(@ModelAttribute Account account) {
		account.set_id(UUID.randomUUID().toString());
		accountRepo.save(account);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/index.html");
		return redirectView;
	}

	@PostMapping("/accounts/{id}/update")
	public Account updateAccount(@PathVariable String id, @RequestBody Account updatedAccount) {
		Optional<Account> accountOptional = accountRepo.findById(id);
		if (accountOptional.isPresent()) {
			Account existingAccount = accountOptional.get();

			existingAccount.setUsername(updatedAccount.getUsername());
			existingAccount.setPassword(updatedAccount.getPassword());
			existingAccount.setProfilepicture(updatedAccount.getProfilepicture());

			// Save the updated account in the repository
			return accountRepo.save(existingAccount);
		}
		return null; // Return null or handle the case where the account with the given ID doesn't
						// exist
	}

}
