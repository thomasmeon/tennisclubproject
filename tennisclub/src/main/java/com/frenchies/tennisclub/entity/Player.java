package com.frenchies.tennisclub.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

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
		int result = 1;
		result = prime * result + ((getMail() == null) ? 0 : getMail().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Player))
			return false;
		final Player other = (Player) obj;
		if ((getMail() == null) ? (other.getMail() != null) : !getMail().equals(other.getMail())) {
			return false;
		}
		return true;
	}

}
