package com.frenchies.tennisclub.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;

//@Author Dore Corentin UCO 473308

/**
 * Class representing an Court.
 *
 * Every court has: - idCourt (Long) - status (Status) // In order to know if
 * the court is available or not - type (courtType) - geolocalisation (latitude
 * and longitude) - hourOfBooking(Hour24) - dateOfBooking (Date) - admin
 * (Boolean) // Return true if the user is an admin or false otherwise
 */

@Entity
public class Court {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourt;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	@NotNull
	@Enumerated(EnumType.STRING)
	private CourtType type;

	private float longitude;

	private float latitude;

	// Constructor
	
	public Court() {
<<<<<<< HEAD
		
=======
	
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
	}

	public Court(Status status, CourtType type, float longitude, float latitude) {
		this.status = status;
		this.type = type;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	//// SETTER AND GETTER/////

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public Long getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Long idCourt) {
		this.idCourt = idCourt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CourtType getCourtType() {
		return type;
	}

	public void setCourtType(CourtType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCourt == null) ? 0 : idCourt.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Court other = (Court) obj;
		if (idCourt == null) {
			if (other.idCourt != null)
				return false;
		} else if (!idCourt.equals(other.idCourt))
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Court [idCourt=" + idCourt + ", status=" + status + ", type=" + type + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}

}
