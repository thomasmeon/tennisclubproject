package com.frenchies.tennisclub.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.frenchies.tennisclub.enums.Hour24;

//@Author Dore Corentin UCO 473308

@Entity
@Table(name="BOOKING")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBooking;
	
	@ManyToOne(optional=false)
	@NotNull
	private People people;
	
	@OneToMany
	@NotNull
	private List<Court> court = new ArrayList<Court>();
		
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBooking;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Hour24 hourOfBooking;
	

	public Booking(Long idBooking) {
		this.idBooking=idBooking;
	}

	public Booking() {
	}
	
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public List<Court> getCourt() {
		return Collections.unmodifiableList(court);
	}

	public void addBookingItem(Court p) {
		court.add(p);
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	
	public Hour24 getHourOfBooking() {
		return hourOfBooking;
	}

	public void setHourOfBooking(Hour24 hourOfBooking) {
		this.hourOfBooking = hourOfBooking;
	}
	
	public Long getIdBooking() {
		return idBooking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate== null) ? 0 : createdDate.hashCode());
		result = prime * result + ((people == null) ? 0 : people.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (people == null) {
			if (other.people != null)
				return false;
		} else if (!people.equals(other.people))
			return false;
		return true;
	}

	
	
}
