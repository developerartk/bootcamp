package com.artur.assignment.repositories;

import com.artur.assignment.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    UserAccount getUserAccountByEmail(String email);
}
