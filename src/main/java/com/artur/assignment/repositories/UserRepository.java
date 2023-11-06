package com.artur.assignment.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artur.assignment.model.UserP;


@Repository
public interface UserRepository extends JpaRepository<UserP, Integer>{

}
