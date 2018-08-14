package com.qa.AccountM.Controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.AccountM.Entities.Account;
import com.qa.AccountM.Repositories.AccounRepository;
import com.qa.AccountM.Services.AccountService;

@RestController
@RequestMapping
public class AccountManagerController {
	
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccounRepository accountRepo;

	@GetMapping("/")
	public String firstPage() {
		return "index";
	}
	
	@GetMapping("/Account")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	@PostMapping("/Account")
	public void addAccount(@RequestBody Account account) {
		if (account.getDateCreated() == null) 
			account.setDateCreated(new Date());
		accountService.addAccount(account);
	}
	
	@PutMapping("/Account/{id}")
	public ResponseEntity<Account> updateAccount (@RequestBody Account account, @PathVariable ("id") Long id) {
		Account updAc = accountRepo.getOne(id);
		updAc.setFirstname(account.getFirstname());
		updAc.setLastname(account.getLastname());
		updAc.setAccountNumber(account.getAccountNumber());
		Account updateAccount = accountRepo.save(updAc);
		return ResponseEntity.ok().body(updateAccount);
		
	}
	
	@DeleteMapping("/Account/{id}")
	public void deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
	}
	
	
	
	
}
