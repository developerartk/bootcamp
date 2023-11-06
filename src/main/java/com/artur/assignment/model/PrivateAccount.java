package com.artur.assignment.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table
public class PrivateAccount implements Account{

	
	@Id
	@SequenceGenerator(
			name = "account_sequence",
			sequenceName = "account_sequence",
			allocationSize = 1
			)
	
	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "account_sequence"
			)
	private int id;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String login;
	private String password;
	private String userFirstName;
	private String userLastName;
	private String protectionKey;
	
	
	public PrivateAccount(String email, String userFirstName, String userLastName, String login, String password) {
		this.email = email;
		this.login = login;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.password = password;
	}
	
	

	public PrivateAccount() {
		super();
	}



	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}


	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	@Override
	public String toString() {
		return "PrivateAccount [id=" + id + ", email=" + email + ", login=" + login + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + "]";
	}


	public String getProtectionKey() {
		return protectionKey;
	}


	public void setProtectionKey(String protectionKey) {
		this.protectionKey = protectionKey;
	}
	
	
	
	
	
	
	

	
	
	
	
	
}

