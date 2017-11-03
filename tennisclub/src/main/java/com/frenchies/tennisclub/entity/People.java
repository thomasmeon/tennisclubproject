package com.frenchies.tennisclub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

//@Author Dore Corentin UCO 473308
@Entity
@Table(name = "People")
public abstract class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(nullable=false,unique=true)
	@Pattern(regexp=".+@.+\\....?")
	@NotNull
	private String mail;
	@NotNull
	protected String name;
	@NotNull
	protected String surname;
	@NotNull
	protected String login;
	@NotNull
	protected String password;

	
	////SETTER AND GETTER/////
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}