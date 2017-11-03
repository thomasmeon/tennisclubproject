package com.frenchies.tennisclub.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


/* CLASS PLAYER */

@Entity
@Table(name="Player")
public class Player extends People {
	
	
	@Column(nullable=false,unique=true)
	@Pattern(regexp=".+@.+\\....?")
	@NotNull
	private String mail;
	

	@NotNull
	@Column(nullable=false)
	private String phone;
	
		
	
	@NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Past
    private Date dateOfBirth;
	
		
	//////GETTER AND SETTER //////

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		 result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
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
	if ((getEmail() == null) ? (other.getEmail() != null) : !getEmail().equals(other.getEmail())) {
        return false;
	}
		return true;
	}
	
	
}
