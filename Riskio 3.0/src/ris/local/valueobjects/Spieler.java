package ris.local.valueobjects;

import java.util.ArrayList;

public class Spieler {

	private String name;
	private int nummer;
	public enum Farbe{ROT,BLAU,GRUEN,GELB}
	private Farbe farbe;
	private Karten missionsKarte;
	private int einheiten;
	
	
	



	public Spieler(String name, int nummer, Farbe farbe, Karten missionsKarte, int einheiten) {
		super();
		this.name = name;
		this.nummer = nummer;
		this.farbe = farbe;
		this.missionsKarte = missionsKarte;
		this.einheiten = einheiten;
	}

	
	public Farbe getFarbe() {
		return farbe;
	}


	public void setFarbe(Farbe farbe) {
		this.farbe = farbe;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public Karten getMissionsKarte() {
		return missionsKarte;
	}
	public void setMissionsKarte(Karten missionsKarte) {
		this.missionsKarte = missionsKarte;
	}
	public int getEinheiten() {
		return einheiten;
	}
	public void setEinheiten(int einheiten) {
		this.einheiten = einheiten;
	}

	
	
	
	


}
