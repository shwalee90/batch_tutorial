package com.example.SpringBatchTutorial.core.domain.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accounts,Integer> {

}
