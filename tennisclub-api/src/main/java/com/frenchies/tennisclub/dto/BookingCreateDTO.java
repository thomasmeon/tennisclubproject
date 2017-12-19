package com.frenchies.tennisclub.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.frenchies.tennisclub.enums.Hour24;

/**
 * 
 * @author valentinjacquet 473362
 *
 */
public class BookingCreateDTO {

    @NotNull
    private Long idUser1;

    @NotNull
	private Long idUser2;

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

	public Long getIdUser1() {
		return idUser1;
	}

	public void setIdUser1(Long idUser1) {
		this.idUser1 = idUser1;
	}

	public Long getIdUser2() {
		return idUser2;
	}

	public void setIdUser2(Long idUser2) {
		this.idUser2 = idUser2;
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
		result = prime * result + ((idUser1 == null) ? 0 : idUser1.hashCode());
		result = prime * result + ((idUser2 == null) ? 0 : idUser2.hashCode());
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
		if (idUser1 == null) {
			if (other.idUser1 != null)
				return false;
		} else if (!idUser1.equals(other.idUser1))
			return false;
		if (idUser2 == null) {
			if (other.idUser2 != null)
				return false;
		} else if (!idUser2.equals(other.idUser2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookingCreateDTO [idUser1=" + idUser1 + ", idUser2=" + idUser2 + ", idCourt=" + idCourt
				+ ", dateOfBooking=" + dateOfBooking + ", hourOfBooking=" + hourOfBooking + "]";
	}

}
