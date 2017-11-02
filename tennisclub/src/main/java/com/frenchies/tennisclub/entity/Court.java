package com.frenchies.tennisclub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;

@Entity
@Table(name = "COURT_ITEM")
public class Court {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourt;

	/*
	 * @OneToOne private Court court;
	 */

	private Status status;

	private CourtType type;
	
	private int longitude;

	private int lattitude;
	
	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLattitude() {
		return lattitude;
	}

	public void setLattitude(int lattitude) {
		this.lattitude = lattitude;
	}

	public Long getIdCourt() {
		return idCourt;
	}

	public void setIdCourt(Long idCourt) {
		this.idCourt = idCourt;
	}

	public Status getIdStatus() {
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
