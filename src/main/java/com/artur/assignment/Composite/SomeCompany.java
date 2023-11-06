package com.artur.assignment.Composite;

public class SomeCompany {
	User user1 = new User("Donald Trump");
	User user2 = new User("Abraham Lincoln");
	User user3 = new User("Theodore Roosevelt");
	User user4 = new User("John Kannedy");
	
	Department dep1 = new Department("Dep1");
	Department dep2 = new Department("Dep2");
	Department dep3 = new Department("Dep3");
	
	
	public void addUsersToDep() {
		dep1.addUser(user1);
		dep1.addUser(user2);
		dep1.addUser(user3);
		
		dep2.addUser(dep3);
		dep3.addUser(dep1);
	}

	
	public void getDepartmentInfo() {
		dep1.display();
	}

	
}
