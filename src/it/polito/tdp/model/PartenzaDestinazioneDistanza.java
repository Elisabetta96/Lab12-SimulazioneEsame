package it.polito.tdp.model;

public class PartenzaDestinazioneDistanza {

	private Distretto partenza; 
	private Distretto destinazione; 
	private double distanza;
	public PartenzaDestinazioneDistanza(Distretto partenza, Distretto destinazione, double distanza) {
		super();
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.distanza = distanza;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinazione == null) ? 0 : destinazione.hashCode());
		result = prime * result + ((partenza == null) ? 0 : partenza.hashCode());
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
		PartenzaDestinazioneDistanza other = (PartenzaDestinazioneDistanza) obj;
		if (destinazione == null) {
			if (other.destinazione != null)
				return false;
		} else if (!destinazione.equals(other.destinazione))
			return false;
		if (partenza == null) {
			if (other.partenza != null)
				return false;
		} else if (!partenza.equals(other.partenza))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("PartenzaDestinazioneDistanza [partenza=%s, destinazione=%s, distanza=%s]", partenza,
				destinazione, distanza);
	}
	public Distretto getPartenza() {
		return partenza;
	}
	public void setPartenza(Distretto partenza) {
		this.partenza = partenza;
	}
	public Distretto getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(Distretto destinazione) {
		this.destinazione = destinazione;
	}
	public double getDistanza() {
		return distanza;
	}
	public void setDistanza(double distanza) {
		this.distanza = distanza;
	} 
	
	
	 
}
