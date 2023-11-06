package com.artur.assignment.Composite;

public class SingleUser extends User{
	private String position;
	private int yearsOfExperience;

	public SingleUser(String id, String name, String position, int yearsOfExperience) {
		super(id, name);
		this.position = position;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
	@Override
	public void display() {
		System.out.println("id: " + id + " name: " + name + " position: " + position +
							" Experience: " + yearsOfExperience);
		
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
