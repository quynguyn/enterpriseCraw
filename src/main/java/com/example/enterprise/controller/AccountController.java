package com.example.enterprise.controller;

import com.example.enterprise.model.Account;
import com.example.enterprise.model.Product;
import com.example.enterprise.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
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

	@GetMapping("/accounts/username/{username}")
	public boolean getAccountByUsername(@PathVariable String username) {
		Optional<Account> accountOptional = accountRepo.findByUsername(username);
		System.out.println(accountOptional.isPresent());
		return accountOptional.isPresent();
	}

	@GetMapping("/accounts/{username}/{password}")
	public Account getAccountByUserNameAndPassword(@PathVariable String username, @PathVariable String password) {
		Optional<Account> accountOptional = accountRepo.findByUsernameAndPassword(username, password);
		System.out.println(accountOptional.orElse(null));
		return accountOptional.orElse(null);
	}

	@PostMapping("/accounts/create")
	public RedirectView createAccount(@RequestParam Map<String, String> body) {
		Account account = new Account();

		account.set_id(UUID.randomUUID().toString());

		account.setUsername(body.get("username"));
		account.setPassword(body.get("password"));
		account.setProfilepicture(body.get("image"));
		account.setType(body.get("type"));

		account.setBusinessname(body.get("businessName"));
		account.setBusinessaddress(body.get("businessAddress"));
		account.setName(body.get("name"));
		account.setAddress(body.get("address"));

		System.out.println(body);

		accountRepo.save(account);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://127.0.0.1:5500/src/main/resources/static/index.html");
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
