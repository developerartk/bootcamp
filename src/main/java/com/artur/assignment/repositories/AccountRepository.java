package com.artur.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artur.assignment.model.PrivateAccount;

@Repository
public interface AccountRepository extends JpaRepository<PrivateAccount, Integer>{
	
	PrivateAccount findByEmail (String email);
	

}
