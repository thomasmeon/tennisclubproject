package com.frenchies.tennisclub.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@author 473449 Meon Thomas

/* CLASS MANAGER */

@Entity
public class Manager extends People {

	//////// CONSTRUCTOR///////////
	public Manager() {
		
	}
	
	public Manager(String name, String surname, String login, String password, String mail) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

}
