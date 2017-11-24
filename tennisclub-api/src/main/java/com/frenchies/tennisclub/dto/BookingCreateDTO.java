package com.frenchies.tennisclub.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.frenchies.tennisclub.enums.Hour24;

/**
 * 
 * @author valentinjacquet 473362
 *
 */
public class BookingCreateDTO {
	@NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    private UserDTO user1;

    @NotNull
	private UserDTO user2;

    @NotNull
	private Long idCourt;

    @NotNull
	private Date dateOfBooking;

	private Hour24 hourOfBooking;

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
		result = prime * result + ((dateOfBooking == null) ? 0 : dateOfBooking.hashCode());
		result = prime * result + ((hourOfBooking == null) ? 0 : hourOfBooking.hashCode());
		result = prime * result + ((idCourt == null) ? 0 : idCourt.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BookingCreateDTO other = (BookingCreateDTO) obj;
		if (dateOfBooking == null) {
			if (other.dateOfBooking != null)
				return false;
		} else if (!dateOfBooking.equals(other.dateOfBooking))
			return false;
		if (hourOfBooking != other.hourOfBooking)
			return false;
		if (idCourt == null) {
			if (other.idCourt != null)
				return false;
		} else if (!idCourt.equals(other.idCourt))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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

	@Override
	public String toString() {
		return "BookingCreateDTO [name=" + name + ", user1=" + user1 + ", user2=" + user2 + ", idCourt=" + idCourt
				+ ", dateOfBooking=" + dateOfBooking + ", hourOfBooking=" + hourOfBooking + "]";
	}

}
