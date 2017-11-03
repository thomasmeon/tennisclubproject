package com.frenchies.tennisclub.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/* CLASS MANAGER */

@Entity
@Table(name = "Manager")
public class Manager extends People {

	//////// CONSTRUCTOR///////////
	public Manager(String name, String surname, String login, String password, String mail) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

}
