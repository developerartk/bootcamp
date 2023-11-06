package com.artur.assignment;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.artur.assignment.Composite.Department;
import com.artur.assignment.Composite.SomeCompany;
import com.artur.assignment.Strategy.Context;
import com.artur.assignment.model.PrivateAccount;


@SpringBootApplication
@RestController
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);

	
	////////////////////////////////////////////
	//Kuna web-i ei kasuta, @Controller-eid ei tule ja kõik kood on selles klassis
	////////////////////////////////////////////

		
	
	// Meetod, mis kontrollib factory patterni:
	// Konsoolis näitab meetodit ja kasutaja peab kirjutama - true/false
	// Kui kõik meetodid on märgitud, programm prindib teavituse, millise notifications olid saadetud.
	//Factory factory = new Factory();
	//factory.checkFactory();
	
	// Meetod, mis kontrollib chain of responsibility patterni:
	// Lisada andmebaasi PrivateAccount ja edasi tegutseda konsoolis
	//ChainClass chain = new ChainClass();
	//chain.insertEmail();
	//chain.validate();
		
		
	// Meetod, mis kontrollib strategy patterni:
	//Context context = new Context();
	//context.finishPayment();
		
		
	// Meetod, mis kontrollib Flyweight patterni:
		SomeCompany company = new SomeCompany();
		company.getDepartmentInfo();
		
	
	}
}