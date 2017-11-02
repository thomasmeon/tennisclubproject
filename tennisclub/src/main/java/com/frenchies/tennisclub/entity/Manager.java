package com.frenchies.tennisclub.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//In Derby, its forbiden to 'USER' is reserved keyword, we need to rename table 
@Table(name="Manager")
public class Manager extends People {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String password; 
	
	private String name; 
	private String surname;
	private String mail;
	private String phone;
	private Date dateOfBirth;
	//private Hour24 hourOfBooking;
	private Date dateOfBooking;
	private Long idBooking;
	private Date createdDate;
	
	
	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordHash) {
		this.password = passwordHash;
	}

		
	public String getGivenName() {
		return name;
	}


	public void setGivenName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

		
	public void login(String login, String password) {
		
	}
	
	public void logout(String logout) {
		
	}
	
	//public void makeBooking(int idBooking, Date dateOfBooking, Hours24 hourOfBooking, Date createDate ) {
		
	//}
	
	public void cancelBooking(int idBooking) {
		
	}	
	
	public void createMember(long id, String name, String surname, String mail, String phone, Date dateOfBirth) {
		
	}
	
	public void deleteMember(long id) {
		
	}
	
	public void modifyMember(long id, String name, String surname, String mail, String phone, Date dateOfBirth) {
		
	}
	
	public void getStats(long id) {
		
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (!(obj instanceof Manager))
//			return false;
//		Manager other = (Manager) obj;
//		return true;
//	}
	
	
}
