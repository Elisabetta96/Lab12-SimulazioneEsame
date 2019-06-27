package it.polito.tdp.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.db.EventsDao;

public class Model {
	
	EventsDao dao= new EventsDao();
	
	
	SimpleWeightedGraph <Distretto,DefaultWeightedEdge> grafo ;

	HashMap<Integer,Distretto> mappaDistretti= new HashMap <Integer, Distretto>();
	Collection <Distretto> listaDistretti= new LinkedList<Distretto>();
	List <PartenzaDestinazioneDistanza> listaDistanza;
	

	public List<Integer> implementaBoxAnno() {
		List<Integer>anni = dao.getAnni();
		return anni;	
		
	}


	public void creaGrafo(int anno) {
		
		List <Integer> IDdistretti = this.dao.getDistretti();
		//creare i vertici 
		//per ogni vertice, dato l'anno prendere la media di long e lat 
		for(int i: IDdistretti) {
			Distretto d= this.dao.getMedieLatLongDistrettoperAnno(anno, i);
		
			this.listaDistretti.add(d);
			
		}
		grafo = new SimpleWeightedGraph<Distretto, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, this.listaDistretti);
		
	
		this.listaDistanza= new LinkedList<PartenzaDestinazioneDistanza>();
		for(Distretto d : this.listaDistretti) {
			for(Distretto dd:this.listaDistretti) {
				if(!d.equals(dd)) {
					double distanza=LatLngTool.distance(d.latlong,dd.latlong,LengthUnit.KILOMETER);
					Graphs.addEdgeWithVertices(this.grafo, d, dd, distanza);
					
					this.listaDistanza.add(new PartenzaDestinazioneDistanza(d,dd,distanza));

				}
			}
		}
		System.out.println("Grafo creato!");
		System.out.println("# vertici: " + this.grafo.vertexSet().size());
		System.out.println("# archi: " + this.grafo.edgeSet().size());
	}


	public List<Distretto> trovaVicini(Distretto d) {
		
		List <Distretto> vicini = Graphs.neighborListOf(this.grafo, d);
		List <PartenzaDestinazioneDistanza> listapesi= new LinkedList();
		
		for(Distretto v: vicini) {
			for( PartenzaDestinazioneDistanza pdd: this.listaDistanza) {
				if(d.equals(pdd.getPartenza())&& (v.equals(pdd.getDestinazione()))) {
					listapesi.add(e)
				}
			}
		}
		return null;
	}


	public List<Distretto> getVertex() {
		// TODO Auto-generated method stub
		return (List<Distretto>) this.grafo.vertexSet();
	}
		
	}

