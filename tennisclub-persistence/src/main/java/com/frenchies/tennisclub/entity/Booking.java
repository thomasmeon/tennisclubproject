package com.frenchies.tennisclub.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.frenchies.tennisclub.enums.Hour24;

//@Author Dore Corentin UCO 473308


/**
 * Class representing an Booking.
 *
 * Every booking has:
 * - idBooking (Long)
 * - idBCourt (Long) // In order to identify which court is concerned by the booking
 * - users (User) // Players 
 *-  hourOfBooking(Hour24)
 * - dateOfBooking (Date)
 * - admin (Boolean) // Return true if the user is an admin or false otherwise 
 */


@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooking;

	@NotNull
	private Long idCourt;

	@ManyToOne
	@NotNull
	private User user1;

	@ManyToOne
	@NotNull
	private User user2;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBooking;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Hour24 hourOfBooking;
	
	// Constructor

	public Booking() {

	}

	public Booking(Long idCourt, User user1, User user2, Date dateOfBooking, Hour24 hourOfBooking) {
		this.idCourt = idCourt;
		this.user1 = user1;
		this.user2 = user2;
		this.dateOfBooking = dateOfBooking;
		this.hourOfBooking = hourOfBooking;

	}

	//// SETTER AND GETTER/////

	public Long getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Long idCourt) {
		this.idCourt = idCourt;
	}
	
	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
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

	public void setIdBooking(Long idBooking) {
		this.idBooking = idBooking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBooking == null) ? 0 : dateOfBooking.hashCode());
		result = prime * result + ((hourOfBooking == null) ? 0 : hourOfBooking.hashCode());
		result = prime * result + ((idBooking == null) ? 0 : idBooking.hashCode());
		result = prime * result + ((idCourt == null) ? 0 : idCourt.hashCode());
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
		if (dateOfBooking == null) {
			if (other.dateOfBooking != null)
				return false;
		} else if (!dateOfBooking.equals(other.dateOfBooking))
			return false;
		if (hourOfBooking != other.hourOfBooking)
			return false;
		if (idBooking == null) {
			if (other.idBooking != null)
				return false;
		} else if (!idBooking.equals(other.idBooking))
			return false;
		if (idCourt == null) {
			if (other.idCourt != null)
				return false;
		} else if (!idCourt.equals(other.idCourt))
			return false;
		return true;
	}

}
