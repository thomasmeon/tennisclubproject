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

	public Booking() {

	}

	public Booking(Long idCourt, User user1, User user2, Date dateOfBooking, Hour24 hourOfBooking) {
		this.idCourt = idCourt;
		this.user1 = user1;
		this.user2 = user2;
		this.dateOfBooking = dateOfBooking;
		this.hourOfBooking = hourOfBooking;

	}

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
}
