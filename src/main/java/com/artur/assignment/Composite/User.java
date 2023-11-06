package com.artur.assignment.Composite;

public class User implements UserInterface{
	protected String name;
	protected String id;

		
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	@Override
	public void display() {
		System.out.println(id + " " + name);
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public String getId() {
		return id;
	}

}
