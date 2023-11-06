package com.artur.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artur.assignment.model.UserP;
import com.artur.assignment.repositories.UserRepository;

@Service
@Transactional(readOnly= true)
public class UserService {
	private final UserRepository userRep;
	

	@Autowired
	public UserService(UserRepository userRep) {
		this.userRep = userRep;
	}


	public List<UserP> findAll(){
		return userRep.findAll();
	}

	public UserP getUser(int id) {
		Optional<UserP> user =  userRep.findById(id);
		return user.orElse(null);
	}
	
	
	@Transactional
	public void save(UserP userP) {
		userRep.save(userP);
	}
	
	@Transactional
	public void update(int id, UserP updatedUser) {
		updatedUser.setId(id);
		userRep.save(updatedUser);
	}
	
	@Transactional
	public void delete(int id) {
		userRep.deleteById(id);
	}
	

}
