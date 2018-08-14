package com.qa.AccountM.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.AccountM.Entities.Account;

public interface AccounRepository extends JpaRepository<Account, Long> {

}
