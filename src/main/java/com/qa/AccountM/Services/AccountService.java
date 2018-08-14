package com.qa.AccountM.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.AccountM.Entities.Account;
import com.qa.AccountM.Repositories.AccounRepository;
import javax.persistence.EntityManager;


@Service
public class AccountService {
	
	@Autowired
	private AccounRepository accountRepo; 
	
	
	 
	 public List<Account> getAllAccounts(){
		 
		return accountRepo.findAll();
	 }
	 

	 public void addAccount (Account account) {
		 accountRepo.save(account);
	 }
	 
	 public void updateAccount(Long id, Account account) {
	
		 
		 
			 
		 }
	 
	 
	 public void deleteAccount(Long id) {
		 accountRepo.deleteById(id);
	 }
			 

}
