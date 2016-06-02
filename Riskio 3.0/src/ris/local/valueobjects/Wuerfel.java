package ris.local.valueobjects;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import core.SpielbrettVerwaltung;

public class Wuerfel {

	private int[] wuerfelArray;
	private int zufallszahl;
	private SpielbrettVerwaltung sw;

	public Wuerfel() {
		super();

	}

	public int[] getWuerfelArray() {
		return wuerfelArray;
	}

	public void setWuerfelArray(int[] wuerfelArray) {
		this.wuerfelArray = wuerfelArray;
	}

	public int getZufallszahl() {
		return zufallszahl;
	}

	public void setZufallszahl(int zufallszahl) {
		this.zufallszahl = zufallszahl;
	}
	// Wenn ein Spieler angreifer mit 1 Einheiten auf 1ne Verteidigende Einheiten
	/*public int[] einAeinV(int spielerNr,int spielerNr2,String land1,String land2){
		wuerfelArray = new int[2];

		for(int i = 0; i < wuerfelArray.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray[i] = zufallszahl;
			System.out.println(wuerfelArray[i]);

		}
		if ( wuerfelArray[0] <= wuerfelArray[1]){
			System.out.println("Verteidiger gewinnt");
			for(int i = 0; i < sw.getKontinentArray().length; i++){
				for(int j= 0; j < sw.getKontinentArray()[i].getLaenderArray().length; j++){

					// Setzt die ID des Angeriffenen Landes um ( So das sie die des Siegers bekommt )
					if(land1.equals(sw.getKontinentArray()[i].getLaenderArray()[j].getName())){
						sw.getKontinentArray()[i].getLaenderArray()[j].setEinheiten(-1);
					}
				}
			}

		}else{
			System.out.println("Angreifer gewinnt");
					
			for(int i = 0; i < sw.getKontinentArray().length; i++){
				for(int j= 0; j < sw.getKontinentArray()[i].getLaenderArray().length; j++){

					// Setzt die ID des Angeriffenen Landes um ( So das sie die des Siegers bekommt )
					if(land2.equals(sw.getKontinentArray()[i].getLaenderArray()[j].getName())){
						sw.getKontinentArray()[i].getLaenderArray()[j].setId(spielerNr);
					}
				}
			}

		}
		return wuerfelArray;

	}*/

	public int[] einAzweiV(){
		wuerfelArray = new int[3];
		int counter = 0 ;

		for(int i = 0; i < wuerfelArray.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray[i] = zufallszahl;
			System.out.println(wuerfelArray[i]);

		}
		if ( wuerfelArray[0] > wuerfelArray[1] ){
			counter ++;

		}
		if ( wuerfelArray[0] > wuerfelArray[2] ){
			counter ++;

		}
		if(counter > 0){
			System.out.println("Angreifer gewinnt");
		}else{
			System.out.println("Verteidiger gewinnt;");
		}


		return wuerfelArray;
	}

	public int[] zweiAeinV(){
		wuerfelArray = new int[3];
		int counter = 0 ;

		for(int i = 0; i < wuerfelArray.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray[i] = zufallszahl;
			System.out.println(wuerfelArray[i]);

		}
		if ( wuerfelArray[0] > wuerfelArray[2] ){
			counter ++;

		}
		if ( wuerfelArray[1] > wuerfelArray[2] ){
			counter ++;

		}
		if(counter > 0){
			System.out.println("Angreifer gewinnt");
		}else{
			System.out.println("Verteidiger gewinnt;");
		}
		return wuerfelArray;
	}
	public int[] zweiAzweiV(){
		wuerfelArray = new int[4];
		int counter = 0 ;

		for(int i = 0; i < wuerfelArray.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray[i] = zufallszahl;
			System.out.println(wuerfelArray[i]);

		}
		if ( wuerfelArray[0] > wuerfelArray[2] ){
			counter ++;

		}
		if ( wuerfelArray[1] > wuerfelArray[2] ){
			counter ++;

		}
		if ( wuerfelArray[0] > wuerfelArray[3] ){
			counter ++;

		}
		if ( wuerfelArray[1] > wuerfelArray[3] ){
			counter ++;

		}
		if(counter > 0){
			System.out.println("Angreifer gewinnt");
		}else{
			System.out.println("Verteidiger gewinnt;");
		}
		return wuerfelArray;
	}
	public int[] dreiAeinV(){
		wuerfelArray = new int[4];

		int counter = 0 ;

		for(int i = 0; i < wuerfelArray.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray[i] = zufallszahl;
			System.out.println(wuerfelArray[i]);

		}
		if ( wuerfelArray[0] > wuerfelArray[3] ){
			counter ++;

		}
		if ( wuerfelArray[1] > wuerfelArray[3] ){
			counter ++;

		}
		if ( wuerfelArray[2] > wuerfelArray[3] ){
			counter ++;

		}

		if(counter > 0){
			System.out.println("Angreifer gewinnt");
		}else{
			System.out.println("Verteidiger gewinnt;");
		}
		return wuerfelArray;

	}
	public int[] dreiAzweiV(){
		wuerfelArray = new int[5];

		int counter = 0 ;

		for(int i = 0; i < wuerfelArray.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray[i] = zufallszahl;
			System.out.println(wuerfelArray[i]);

		}
		if ( wuerfelArray[0] > wuerfelArray[3] ){
			counter ++;

		}
		if ( wuerfelArray[1] > wuerfelArray[3] ){
			counter ++;

		}
		if ( wuerfelArray[2] > wuerfelArray[3] ){
			counter ++;

		}
		if ( wuerfelArray[1] > wuerfelArray[4] ){
			counter ++;

		}
		if ( wuerfelArray[2] > wuerfelArray[4] ){
			counter ++;

		}
		if ( wuerfelArray[3] > wuerfelArray[4] ){
			counter ++;

		}
		if(counter > 0){
			System.out.println("Angreifer gewinnt");
			System.out.println("Angreifer verliert durch den Angriff ["+counter+"] Einheiten!");
		}else{
			System.out.println("Verteidiger gewinnt;");
		}
		return wuerfelArray;
	}
}