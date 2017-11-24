package com.frenchies.tennisclub.dto;

import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;

public class CourtDTO {
	private Long idCourt;

	private Status status;

	private CourtType type;

	private int longitude;

	private int lattitude;

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

	public CourtType getType() {
		return type;
	}

	public void setType(CourtType type) {
		this.type = type;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lattitude;
		result = prime * result + longitude;
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
		CourtDTO other = (CourtDTO) obj;
		if (lattitude != other.lattitude)
			return false;
		if (longitude != other.longitude)
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
