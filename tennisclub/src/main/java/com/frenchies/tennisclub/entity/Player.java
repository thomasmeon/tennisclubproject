package com.frenchies.tennisclub.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

// @author 473449 Meon Thomas

/* CLASS PLAYER */

@Entity
@Table(name = "Player")
public class Player extends People {

	@NotNull
	@Column(nullable = false)
	private String phone;

	@NotNull
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@Past
	private Date dateOfBirth;

	////// CONSTRUCTORS /////
	
	public Player() {
		
	}

	public Player(String name, String surname, String login, String password, String mail, String phone,
			Date dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
	}

	////// GETTER AND SETTER //////

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [phone=" + phone + ", dateOfBirth=" + dateOfBirth + ", id=" + id + ", mail=" + mail + ", name="
				+ name + ", surname=" + surname + ", login=" + login + ", password=" + password + "]";
	}

}
