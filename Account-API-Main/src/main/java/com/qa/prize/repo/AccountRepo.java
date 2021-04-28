package com.qa.prize.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.prize.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {


}
