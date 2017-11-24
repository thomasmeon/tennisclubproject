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
import com.frenchies.tennisclub.entity.People;

//@Author Dore Corentin UCO 473308

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooking;

	@NotNull
	private Long idCourt;
	
	@NotNull
	private long idPlayer1;
	
	@NotNull
	private long idPlayer2;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBooking;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Hour24 hourOfBooking;
	
	public Booking() {
		
	}
	
	public Booking(Long idCourt, long idPlayer1, long idPlayer2, Date dateOfBooking,
			Hour24 hourOfBooking) {
		this.idCourt = idCourt;
		this.idPlayer1 = idPlayer1;
		this.idPlayer2 = idPlayer2;
		this.dateOfBooking = dateOfBooking;
		this.hourOfBooking = hourOfBooking;

	}

	public Long getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Long idCourt) {
		this.idCourt = idCourt;
	}
	
	public long getIdPlayer1() {
		return idPlayer1;
	}

	public void setIdPlayer1(long idPlayer1) {
		this.idPlayer1 = idPlayer1;
	}

	public long getIdPlayer2() {
		return idPlayer2;
	}

	public void setIdPlayer2(long idPlayer2) {
		this.idPlayer2 = idPlayer2;
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
		result = prime * result + (int) (idPlayer1 ^ (idPlayer1 >>> 32));
		result = prime * result + (int) (idPlayer2 ^ (idPlayer2 >>> 32));
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
		if (idPlayer1 != other.idPlayer1)
			return false;
		if (idPlayer2 != other.idPlayer2)
			return false;
		return true;
	}

}
