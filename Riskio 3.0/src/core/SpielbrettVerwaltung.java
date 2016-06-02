package core;

import ris.local.valueobjects.Karten;
import ris.local.valueobjects.Kontinent;
import ris.local.valueobjects.Laender;
import ris.local.valueobjects.Spieler;
import ris.local.valueobjects.Wuerfel.Wuerfel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import java.lang.Math;

public class SpielbrettVerwaltung {

	private Kontinent[] kontinentArray;
	private int[][] nachbarMatrix;
	private Wuerfel wuerfel;
	private Spieler[] spielerArray;




	public SpielbrettVerwaltung( int spielerAnzahl) {
		//	this.nachbarMatrix = (Nachbarmatrix;		
		Laender[] laenderNA = new Laender[9];
		laenderNA = new Laender[]{new Laender("Alaska",0,0,0),new Laender("Nordwest-Territorium",0,0,1),new Laender("Gr�nland",0,0,2),new Laender("Alberta",0,0,3),new Laender("Ontario",0,0,4),new Laender("Quebec",0,0,5),new Laender("Weststaaten",0,0,6),new Laender("Oststaaten",0,0,7),new Laender("Mittelamerika",0,0,8)};

		Laender[] laenderSA = new Laender[4];
		laenderSA = new Laender[]{new Laender("Venezuela",0,0,9),new Laender("Peru",0,0,10),new Laender("Brasilien",0,0,11),new Laender("Argentinien",0,0,12)};

		Laender[] laenderAfrika = new Laender[6];
		laenderAfrika = new Laender[]{new Laender("Nordwest-Afrika",0,0,13),new Laender("�gypten",0,0,14),new Laender("Ost-Afrika",0,0,15),new Laender("Kongo",0,0,16),new Laender("S�d-Afrika",0,0,17),new Laender("Madagaskar",0,0,18)};

		Laender[] laenderEU = new Laender[7];
		laenderEU = new Laender[]{new Laender("Island",0,0,19),new Laender("Skandinavien",0,0,20),new Laender("Gro�britanien",0,0,21),new Laender("West-Europa",0,0,22),new Laender("Mitteleuropa",0,0,23),new Laender("S�d-Europa",0,0,24),new Laender("Ukraine",0,0,25)};

		Laender[] laenderAsien = new Laender[12];
		laenderAsien = new Laender[]{new Laender("Ural",0,0,26),new Laender("Sibirien",0,0,27),new Laender("Jakutien",0,0,28),new Laender("Kmtchatka",0,0,29),new Laender("Irkutsk",0,0,30),new Laender("Mongolei",0,0,31),new Laender("Afghanistan",0,0,32),new Laender("Mittlerer-Osten",0,0,33),new Laender("Indien",0,0,34),new Laender("China",0,0,35),new Laender("Japan",0,0,36),new Laender("Siam",0,0,37)};

		Laender[] laenderAustralien = new Laender[4];
		laenderAustralien = new Laender[]{new Laender("Indonesien",0,0,38),new Laender("Neuguinea",0,0,39),new Laender("West-Australien",0,0,40),new Laender("Ost-Australien",0,0,41)};

		this.kontinentArray = new Kontinent[6];

		kontinentArray[0] = new Kontinent(laenderNA,"Nordamerika",5);
		kontinentArray[1] = new Kontinent(laenderSA,"S�damerika",2);
		kontinentArray[2] = new Kontinent(laenderAfrika,"Afrika",3);
		kontinentArray[3] = new Kontinent(laenderEU,"Europa",5);
		kontinentArray[4] = new Kontinent(laenderAsien,"Asien",7);
		kontinentArray[5] = new Kontinent(laenderAustralien,"Australien",2);



		Wuerfel wuerfel = new Wuerfel(new int[0],0);
		// Amount + W�rfelA

		Stack<Karten> auftragsKarten = new Stack<Karten>();
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG1));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG2));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG3));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG4));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG5));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG6));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG7));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG8));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG9));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG10));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG11));
		auftragsKarten.add(new Karten(Karten.Name.AUFTRAG12));

		java.util.Collections.shuffle(auftragsKarten);



		spielerArray = new Spieler[spielerAnzahl];
		spielerArray[0] = new Spieler("",1,Spieler.Farbe.ROT,auftragsKarten.pop(),0);
		spielerArray[1] = new Spieler("",2,Spieler.Farbe.GRUEN,auftragsKarten.pop(),0);
		spielerArray[2] = new Spieler("",3,Spieler.Farbe.BLAU,auftragsKarten.pop(),0);
		spielerArray[3] = new Spieler("",4,Spieler.Farbe.GELB,auftragsKarten.pop(),0);

		//Nachbarmatrix: Zeile 1/Spalte 1 f�r L�nderIDs, 0 f�r keine Nachbarschaft, 1 f�r Nachbarschaft.
		nachbarMatrix = new int[][] {
			{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41},
			{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{2, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{3, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{4, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{5, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{6, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{7, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{8, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{9, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{10,0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{11,0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{12,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{13,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{14,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{15,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{16,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{17,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{18,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{19,0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{20,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{21,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{22,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{23,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{24,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{25,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{26,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{27,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{28,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{29,1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{30,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{31,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
			{32,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{33,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{34,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
			{35,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0},
			{36,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{37,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0},
			{38,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
			{39,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
			{40,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
			{41,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}
		};
	}


	// getNachbarn Methode.
	public int[] nachbarRausfiltern(String land){
		int[] nachbarArray;
		List<Integer> nachbarList = new ArrayList<Integer>();


		for(int i = 0; i < kontinentArray.length ; i++){
			for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){


				if(land.equals(kontinentArray[i].getLaenderArray()[j].getName())){
					int laenderID = kontinentArray[i].getLaenderArray()[j].getId();
					laenderID ++;
					for(int y = 1; y < nachbarMatrix[laenderID].length;y++){
						if(nachbarMatrix[laenderID][y]== 1){
							nachbarList.add(nachbarMatrix[0][y]);

						}
					}	
				}
			}
		}System.out.println(nachbarList);
		nachbarArray = new int[nachbarList.size()];
		for(int u = 0; u <nachbarArray.length; u++){
			nachbarArray[u] = nachbarList.remove(0);

		}return nachbarArray;


	}
	// Methode, um die ausgegebene L�nderID zum jeweiligen L�ndernamen zu �ndern/returnen.
	public String idToLand(int id){
		for(int i = 0; i < kontinentArray.length ; i++){
			for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){
				if(id == kontinentArray[i].getLaenderArray()[j].getId()){
					return kontinentArray[i].getLaenderArray()[j].getName();
				}
			}
		}return "Fantasialand";
	}

	// Methode um die besetzten L�nder eines ausgew�hlten Spielers zu ermitteln.
	public int countLaender(int spieler){
		int counter = 0;
		for(int i = 0; i < kontinentArray.length ; i++){
			for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){

				if(spieler == kontinentArray[i].getLaenderArray()[j].getBelegt()){
					counter ++;
				}
			}
		}
		return counter;
	}

	// Methode, um zu Beginn des Zuges eines Spielers die Armeen nach Regelwerk zu setzen.
	public void setNeueArmee(int spieler){
		int armee = spielerArray[spieler-1].getEinheiten();

		if(countLaender(spieler)>9){
			//				if(countLaender(spieler)%3 == 0){
			//					spielerArray[spieler].setEinheiten(countLaender(spieler)/3 + armee);
			//				}
			//				else {		 
			spielerArray[spieler-1].setEinheiten((int) Math.floor(countLaender(spieler)/3 + armee));
			//				}

		}else{
			spielerArray[spieler-1].setEinheiten(armee + 3);

		}
	}

	//Alle L�nder von einem Spieler zum test belegen.
	public void alle(){

		for(int i = 0; i < kontinentArray.length ; i++){
			for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){
				kontinentArray[i].getLaenderArray()[j].setBelegt(4);

			}
		}
	}
	
	public boolean einheitenBonus(int spieler){
		for(int i = 0; i< kontinentArray.length; i++){
			for(int j = 0; j < kontinentArray[i].getLaenderArray().length;j++){
				if(kontinentArray[i].getLaenderArray()[j].getBelegt();
		
			}
		}
	}


	// Getter & Setter
	public Kontinent[] getKontinentArray() {
		return kontinentArray;
	}
	public void setKontinentArray(Kontinent[] kontinentArray) {
		this.kontinentArray = kontinentArray;
	}
	public Wuerfel getWuerfel() {
		return wuerfel;
	}
	public void setWuerfel(Wuerfel wuerfel) {
		this.wuerfel = wuerfel;
	}
	public Spieler[] getSpielerArray() {
		return spielerArray;
	}
	public void setSpielerArray(Spieler[] spielerArray) {
		this.spielerArray = spielerArray;
	}


	// Verteilt zu Beginn des Spiels reihum Spieler f�r Spieler jeweils eine Einheit auf einem zuf�lligem Land.
	public void einheitenVerteilen(){
		int shuffleLength = 42;
		List<Integer> intSet = new ArrayList<Integer>();
		int i = 0;
		while( i< shuffleLength){


			for(int k = 1;k<spielerArray.length +1;k++){

				intSet.add(k);
				i++;
				if( i>= shuffleLength){
					break;
				}

			}
		}
		java.util.Collections.shuffle(intSet);
		for(int j = 0; j<kontinentArray.length; j++){
			for(int k = 0;k<kontinentArray[j].getLaenderArray().length;k++){
				Laender[] laenderArray = kontinentArray[j].getLaenderArray();			
				laenderArray[k].setBelegt(intSet.remove(0));
				laenderArray[k].setEinheiten(1);
				kontinentArray[j].setLaenderArray(laenderArray);
			}


		}
	}
}