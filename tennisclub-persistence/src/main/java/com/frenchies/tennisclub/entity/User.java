package com.frenchies.tennisclub.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */

@Entity
//In Derby, its forbiden to 'USER' is reserved keyword, we need to rename table 
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(nullable=false,unique=true)
	@Pattern(regexp=".+@.+\\....?")
	@NotNull
	protected String mail;

	@NotNull
	protected String name;

	@NotNull
	protected String surname;

	@NotNull
	protected String login;

	protected String passwordHash;

	@NotNull
	@Pattern(regexp = "\\+?\\d+")
	private String phone;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@Past
	private Date dateOfBirth;

	private boolean admin;

	// Constructor
	
	public User() {
		
	}

	public User(String name, String surname, String login, String password, String mail, String phone,
			Date dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.passwordHash = password;
		this.mail = mail;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
	}

	//// SETTER AND GETTER/////

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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	//// METHODS OF PEOPLE////

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", Name='" + name + '\'' + ", Surname='" + surname + '\'' + ", email='" + mail
				+ '\'' + ", password='" + passwordHash + '\'' + ", login=" + login + '}';
	}
}
