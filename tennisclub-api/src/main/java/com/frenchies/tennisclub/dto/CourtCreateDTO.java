package com.frenchies.tennisclub.dto;

import javax.validation.constraints.NotNull;

import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;

/**
 * 
 * @author thomasmeon 473449
 *
 */
public class CourtCreateDTO {
	
    @NotNull
	private Long idCourt;
    
    @NotNull
	private Status status;
    
    @NotNull
    private CourtType courtType;
    
    private float longitude;

	private float latitude;

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
		return courtType;
	}

	public void setCourtType(CourtType courtType) {
		this.courtType = courtType;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCourt == null) ? 0 : idCourt.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((courtType == null) ? 0 : courtType.hashCode());
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
		CourtCreateDTO other = (CourtCreateDTO) obj;
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
		if (courtType != other.courtType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourtCreateDTO [idCourt=" + idCourt + ", status=" + status + ", type=" + courtType + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
	}

    
	
}
