package core;

import java.util.Iterator;
import java.util.LinkedList;

import ris.local.valueobjects.Spieler;

public class Turn {

	private Spieler spieler;
	private int phase;
	private SpielbrettVerwaltung sw;


	public Turn(Spieler spieler, int phase, SpielbrettVerwaltung sw) {
		super();
		this.spieler = spieler;
		this.phase = phase;
		this.sw = sw;
	}
	
	
	
	public void Reihum(){

		LinkedList player = new LinkedList();

		Spieler[] spielerArray = sw.getSpielerArray();
		for(int i= 0; i<spielerArray.length;i++){
			player.add(spielerArray[i]);
		}

	}


	public Spieler getSpieler() {
		return spieler;
	}
	public void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}


}
