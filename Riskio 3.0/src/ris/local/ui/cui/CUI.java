package ris.local.ui.cui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import core.SpielbrettVerwaltung;
import ris.local.valueobjects.Spieler;

public class CUI {
	
	public static void main(String[] args) {
	
		CUI cui = new CUI();
		cui.run();
		
		
	}
	
	private SpielbrettVerwaltung sw;
	
	private BufferedReader br;
	public void setConsoleLine(String s){
		System.out.println(s);
	}
	public String getInputLine(){
		String s = "";
		try {
			s=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public int getInputInt(){
		return Integer.parseInt(getInputLine());
	}
	
	public void SpielbrettAnzeigen(){
		for(int i = 0;i < sw.getKontinentArray().length;i++){
			System.out.println(sw.getKontinentArray()[i].getName());
			for(int j = 0;j < sw.getKontinentArray()[i].getLaenderArray().length;j++){
				System.out.println(sw.getKontinentArray()[i].getLaenderArray()[j].getName());
				System.out.println("Spieler: " + sw.getKontinentArray()[i].getLaenderArray()[j].getBelegt()+ " Einheiten: " + sw.getKontinentArray()[i].getLaenderArray()[j].getEinheiten());
			}
		}
		System.out.println();
	}
	
	public void run(){
		do{
		System.out.println("aktion:");
		try {
			String input = br.readLine();
			if(input.equals("einheitenVerteilen")){
				sw.einheitenVerteilen();
			}
				
			if(input.equals("spielbrettAnzeigen")){
				SpielbrettAnzeigen();
			}
			if(input.equals("alle4")){
				sw.alle();
			}
			if(input.equals("laenderZaehlen")){
				int inputt = Integer.parseInt(br.readLine());
				int laender = sw.countLaender(inputt);
				System.out.println("Spieler: " + inputt + " besitzt " + laender + " L�nder");
				}
			if(input.equals("neueArmee")){
				int inputt = Integer.parseInt(br.readLine());
				sw.setNeueArmee(inputt);
				Spieler[] spieler = sw.getSpielerArray();
				int print = spieler[inputt-1].getEinheiten();
				System.out.println("Spieler: " + inputt + " kann " + print + " Einheiten setzen.");
				}
			if(input.equals("na")){
				input = br.readLine();
				int[] nachbar = sw.nachbarRausfiltern(input);
				for(int i = 0; i < nachbar.length ; i ++){
					System.out.println(sw.idToLand(nachbar[i]));
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(true);
	}
	
	public CUI() {
		
		super();
		this.br =  new BufferedReader(new InputStreamReader(System.in));
		sw = new SpielbrettVerwaltung(4);
		
	}
	
}
