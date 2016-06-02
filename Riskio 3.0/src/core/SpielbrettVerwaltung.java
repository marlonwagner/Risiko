
package core;
 
import ris.local.valueobjects.Karten;
import ris.local.valueobjects.Kontinent;
import ris.local.valueobjects.Laender;
import ris.local.valueobjects.Spieler;
import ris.local.valueobjects.Wuerfel;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
 
public class SpielbrettVerwaltung {
 
    private Kontinent[] kontinentArray;
    private int[][] nachbarMatrix;
    private Spieler[] spielerArray;
    private Wuerfel[] wuerfelArray;
 
 
 
 
    public SpielbrettVerwaltung( int spielerAnzahl) {
        //  this.nachbarMatrix = (Nachbarmatrix;        
        Laender[] laenderNA = new Laender[9];
        laenderNA = new Laender[]{new Laender("Alaska",0,0,0),new Laender("Nordwest-Territorium",0,0,1),new Laender("Grönland",0,0,2),new Laender("Alberta",0,0,3),new Laender("Ontario",0,0,4),new Laender("Quebec",0,0,5),new Laender("Weststaaten",0,0,6),new Laender("Oststaaten",0,0,7),new Laender("Mittelamerika",0,0,8)};
 
        Laender[] laenderSA = new Laender[4];
        laenderSA = new Laender[]{new Laender("Venezuela",0,0,9),new Laender("Peru",0,0,10),new Laender("Brasilien",0,0,11),new Laender("Argentinien",0,0,12)};
 
        Laender[] laenderAfrika = new Laender[6];
        laenderAfrika = new Laender[]{new Laender("Nordwest-Afrika",0,0,13),new Laender("Ägypten",0,0,14),new Laender("Ost-Afrika",0,0,15),new Laender("Kongo",0,0,16),new Laender("Süd-Afrika",0,0,17),new Laender("Madagaskar",0,0,18)};
 
        Laender[] laenderEU = new Laender[7];
        laenderEU = new Laender[]{new Laender("Island",0,0,19),new Laender("Skandinavien",0,0,20),new Laender("Goßbritanien",0,0,21),new Laender("West-Europa",0,0,22),new Laender("Mitteleuropa",0,0,23),new Laender("Süd-Europa",0,0,24),new Laender("Ukraine",0,0,25)};
 
        Laender[] laenderAsien = new Laender[12];
        laenderAsien = new Laender[]{new Laender("Ural",0,0,26),new Laender("Sibirien",0,0,27),new Laender("Jakutien",0,0,28),new Laender("Kmtchatka",0,0,29),new Laender("Irkutsk",0,0,30),new Laender("Mongolei",0,0,31),new Laender("Afghanistan",0,0,32),new Laender("Mittlerer-Osten",0,0,33),new Laender("Indien",0,0,34),new Laender("China",0,0,35),new Laender("Japan",0,0,36),new Laender("Siam",0,0,37)};
 
        Laender[] laenderAustralien = new Laender[4];
        laenderAustralien = new Laender[]{new Laender("Indonesien",0,0,38),new Laender("Neuguinea",0,0,39),new Laender("West-Australien",0,0,40),new Laender("Ost-Australien",0,0,41)};
 
        this.kontinentArray = new Kontinent[6];
 
        kontinentArray[0] = new Kontinent(laenderNA,"Nordamerika",5);
        kontinentArray[1] = new Kontinent(laenderSA,"Südamerika",2);
        kontinentArray[2] = new Kontinent(laenderAfrika,"Afrika",3);
        kontinentArray[3] = new Kontinent(laenderEU,"Europa",5);
        kontinentArray[4] = new Kontinent(laenderAsien,"Asien",7);
        kontinentArray[5] = new Kontinent(laenderAustralien,"Australien",2);
 
 
 
 
        // Amount + WürfelA
        // Die Auftragskarten werden in den Stack gepackt
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
 
 
        // Die Spieler werden erstellt und in ein Array gepackt
        spielerArray = new Spieler[spielerAnzahl];
        spielerArray[0] = new Spieler("",1,Spieler.Farbe.ROT,auftragsKarten.pop(),0);
        spielerArray[1] = new Spieler("",2,Spieler.Farbe.GRUEN,auftragsKarten.pop(),0);
        spielerArray[2] = new Spieler("",3,Spieler.Farbe.BLAU,auftragsKarten.pop(),0);
        spielerArray[3] = new Spieler("",4,Spieler.Farbe.GELB,auftragsKarten.pop(),0);
        // die Matrix für die Nachbarschaften von den Ländern ( 0-41 ID´s der Länder  ) überall wo eine eins ist sind die länder benachbart
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
    //Nachdem eine Spieler ein Land seiner wahl eingegeben hat, werden ihm die Nachbarländer zu diesem angezeigt
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
    // Wandelt die Rausgefilterte ID so um, dass in der Konsole die Namen angezeigt werden anstatt der ID´s
    public String idToLand(int id){
        for(int i = 0; i < kontinentArray.length ; i++){
            for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){
                if(id == kontinentArray[i].getLaenderArray()[j].getId()){
                    return kontinentArray[i].getLaenderArray()[j].getName();
                }
            }
        }return "Fantasialand";
    }
    // überprüft zwei Länder auf Nachbarschaft.
    public void laenderNachbarUeberpruefen(String land1, String land2){
        int laenderID;
        int laenderID2;
        int counter = 0;
        int einheiten1 = 0;
        int einheiten2 = 0;
         
         
        for(int i = 0; i < kontinentArray.length ; i++){
            for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){
                 
 
                if(land1.equals(kontinentArray[i].getLaenderArray()[j].getName())){
                    laenderID = kontinentArray[i].getLaenderArray()[j].getId();
                    laenderID ++;
                     
                    for(int i2 = 0; i2 < kontinentArray.length ; i2++){
                        for(int j2= 0; j2 < kontinentArray[i2].getLaenderArray().length; j2++){
 
 
                            if(land2.equals(kontinentArray[i2].getLaenderArray()[j2].getName())){
                                laenderID2 = kontinentArray[i2].getLaenderArray()[j2].getId();
                                laenderID2 ++;
                                if(nachbarMatrix[laenderID][laenderID2]==1){
                                    System.out.println("Sind nachbarn");
                                     
                                    }else{
                                        counter++;
                                    }
                                }
                                }
                            }
                        }
                }
            }
        if(counter>0){
        System.out.println("Sind keine Nachbarn");  
        counter = counter - counter;
        }
        //Überprüfen ob Angreifer mindestens 2 verteidiger mindestens 1 einheit hat
        for(int i = 0; i < kontinentArray.length ; i++){
            for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){
                //Angreifer
                if(land1.equals(kontinentArray[i].getLaenderArray()[j].getName())){
                     
                    einheiten1 = kontinentArray[i].getLaenderArray()[j].getEinheiten();
                    System.out.println(einheiten1);
                     
                }
                //Verteidiger
                if(land2.equals(kontinentArray[i].getLaenderArray()[j].getName())){
                    kontinentArray[i].getLaenderArray()[j].setEinheiten(2);
                    einheiten2 = kontinentArray[i].getLaenderArray()[j].getEinheiten();
                    System.out.println(einheiten2);
                }
            }
        }
        if(einheiten1 > 1 & einheiten2 > 0){
            System.out.println("Einheiten Angreifer:"+"["+einheiten1 +"]"+"Einheiten Verteidigung:"+"["+ einheiten2+"]");
            System.out.println("Regel: zum angreifen benötigt der ANGREIFER[2] & VERTEIDIGER[1] Einheiten.");
        }else{
            System.out.println("Fehler bei der Anzahl der Einheiten auf den ausgewählten Ländern.");
        }
        }
         
         
         
    // Überprüfen ob die eingegebenen Länder Nachbarn sind-> Überprüfen ob Angreifer mindestens 2 verteidiger mindestens 1 einheit hat->
    /*  public void angriff(int einheitenAnzahl,String landAusgehend,String landEingehend){
 
        for(int i = 0; i < kontinentArray.length ; i++){
            for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){
                if()
             
            }
        }   
    }*/
 
 
    public Kontinent[] getKontinentArray() {
        return kontinentArray;
    }
    public void setKontinentArray(Kontinent[] kontinentArray) {
        this.kontinentArray = kontinentArray;
    }
 
    public Spieler[] getSpielerArray() {
        return spielerArray;
    }
    public void setSpielerArray(Spieler[] spielerArray) {
        this.spielerArray = spielerArray;
    }
 
 
 
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
 
    public Wuerfel[] getWuerfelArray() {
        return wuerfelArray;
    }
 
    public void setWuerfelArray(Wuerfel[] wuerfelArray) {
        this.wuerfelArray = wuerfelArray;
    }
    
    public int[] einAeinV(int spielerNr,int spielerNr2,String land1,String land2){
		int[] wuerfelArray2 = new int[2];
		int zufallszahl;
		for(int i = 0; i < wuerfelArray2.length ; i ++){
			zufallszahl = (int) ((Math.random()*6)+1);
			wuerfelArray2[i] = zufallszahl;
			System.out.println(wuerfelArray2[i]);

		}
		if ( wuerfelArray2[0] <= wuerfelArray2[1]){
			System.out.println("Verteidiger gewinnt");
			for(int i = 0; i < kontinentArray.length; i++){
				for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){

					// Setzt die ID des Angeriffenen Landes um ( So das sie die des Siegers bekommt )
					if(land1.equals(kontinentArray[i].getLaenderArray()[j].getName())){
						kontinentArray[i].getLaenderArray()[j].setEinheiten(-1);
					}
				}
			}

		}else{
			System.out.println("Angreifer gewinnt");
					
			for(int i = 0; i < kontinentArray.length; i++){
				for(int j= 0; j < kontinentArray[i].getLaenderArray().length; j++){

					// Setzt die ID des Angeriffenen Landes um ( So das sie die des Siegers bekommt )
					if(land2.equals(kontinentArray[i].getLaenderArray()[j].getName())){
						kontinentArray[i].getLaenderArray()[j].setEinheiten(-1);
					}
				}
			}

		}
		return wuerfelArray2;

	}
    
    
    
    
}