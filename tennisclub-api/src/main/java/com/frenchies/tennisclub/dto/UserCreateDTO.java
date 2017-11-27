package com.frenchies.tennisclub.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Author Dore Corentin UCO 473308

public class UserCreateDTO {
	@NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(min = 3, max = 50)
    private String surname;
    
    @NotNull
    @Size(min = 3, max = 50)
    private String mail;
    
    @NotNull
    @Size(min = 3, max = 50)
    private String phone;
    
    @Size(min = 3, max = 50)
    private String passwordHash;
    
    @NotNull
    @Size(min = 3, max = 50)
    private Date dateOfBirth;
    
    private boolean admin; 

    public UserCreateDTO() {
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
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

    

    
}
