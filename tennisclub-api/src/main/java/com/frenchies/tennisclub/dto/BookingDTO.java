package com.frenchies.tennisclub.dto;

import java.util.Date;

import com.frenchies.tennisclub.enums.Hour24;

/**
 * 
 * @author valentinjacquet 473362
 *
 */
public class BookingDTO {
	private Long idBooking;

	private Long idCourt;

	private UserDTO user1;

	private UserDTO user2;

	private Date dateOfBooking;

	private Hour24 hourOfBooking;

	public Long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(Long idBooking) {
		this.idBooking = idBooking;
	}

	public Long getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Long idCourt) {
		this.idCourt = idCourt;
	}

	public UserDTO getUser1() {
		return user1;
	}

	public void setUser1(UserDTO user1) {
		this.user1 = user1;
	}

	public UserDTO getUser2() {
		return user2;
	}

	public void setUser2(UserDTO user2) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hourOfBooking == null) ? 0 : hourOfBooking.hashCode());
		result = prime * result + ((idBooking == null) ? 0 : idBooking.hashCode());
		result = prime * result + ((idCourt == null) ? 0 : idCourt.hashCode());
		result = prime * result + ((user1 == null) ? 0 : user1.hashCode());
		result = prime * result + ((user2 == null) ? 0 : user2.hashCode());
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
		BookingDTO other = (BookingDTO) obj;
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
		if (user1 == null) {
			if (other.user1 != null)
				return false;
		} else if (!user1.equals(other.user1))
			return false;
		if (user2 == null) {
			if (other.user2 != null)
				return false;
		} else if (!user2.equals(other.user2))
			return false;
		return true;
	}

}
