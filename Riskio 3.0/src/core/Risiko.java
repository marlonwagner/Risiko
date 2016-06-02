package core;

import ris.local.valueobjects.Laender;
import ris.local.valueobjects.Spieler;

public class Risiko {

	SpielbrettVerwaltung sw;
	SpielerVerwaltung pw;
	Logik lg;
	
	public Risiko(int spielerAnzahl) {
		super();
		this.sw = new SpielbrettVerwaltung(spielerAnzahl);
		
	}
	
	public SpielbrettVerwaltung getSw() {
		return sw;
	}
	public void setSw(SpielbrettVerwaltung sw) {
		this.sw = sw;
		
	}
/*
	public void provinzVerstaerken(Spieler spieler, Laender land, int noOfUnits) {
		lg.provinzVerstaerken(...);
	}
	*/
	
}
