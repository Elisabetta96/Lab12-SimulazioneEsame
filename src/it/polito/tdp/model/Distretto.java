package it.polito.tdp.model;

import com.javadocmd.simplelatlng.LatLng;

public class Distretto {
	
	int IDdistretto; 
	LatLng latlong;
	public Distretto(int iDdistretto, LatLng latlong) {
		super();
		IDdistretto = iDdistretto;
		this.latlong = latlong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IDdistretto;
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
		Distretto other = (Distretto) obj;
		if (IDdistretto != other.IDdistretto)
			return false;
		return true;
	}
	public int getIDdistretto() {
		return IDdistretto;
	}
	public void setIDdistretto(int iDdistretto) {
		IDdistretto = iDdistretto;
	}
	public LatLng getLatlong() {
		return latlong;
	}
	public void setLatlong(LatLng latlong) {
		this.latlong = latlong;
	}
	@Override
	public String toString() {
		return String.format("Distretto [IDdistretto=%s, latlong=%s]", IDdistretto, latlong);
	}

	
}
