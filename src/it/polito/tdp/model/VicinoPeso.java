package it.polito.tdp.model;

import java.util.Comparator;

public class VicinoPeso implements Comparator {
	
	Distretto vicino; 
	double peso;
	public VicinoPeso(Distretto vicino, double peso) {
		super();
		this.vicino = vicino;
		this.peso = peso;
	}
	public Distretto getVicino() {
		return vicino;
	}
	public void setVicino(Distretto vicino) {
		this.vicino = vicino;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	
	public int compareTo(VicinoPeso o) {
		
		return (int) (this.peso-o.peso);
	}
	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	} 
	

}
