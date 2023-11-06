package com.artur.assignment.Composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends User{
	protected List<UserInterface> users = new ArrayList<>();

	public Department(String id, String name) {
		super(id, name);
	}
	
	public void addUser(UserInterface user) {
		users.add(user);
	}
	
	public get


}
