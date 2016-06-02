package ris.local.ui.cui;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import core.SpielbrettVerwaltung;
import ris.local.valueobjects.Wuerfel;
 
public class CUI {
     
    public static void main(String[] args) {
     
        CUI cui = new CUI();
        cui.run();
         
         
    }
     
    private SpielbrettVerwaltung sw;
    private Wuerfel ww;
     
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
            if(input.equals("nachbarnAnzeigen")){
                input = br.readLine();
                int[] deineMutter = sw.nachbarRausfiltern(input);
                for(int i = 0; i < deineMutter.length ; i ++){
                    System.out.println(sw.idToLand(deineMutter[i]));
                }
                 
            }
            if(input.equals("angreifen")){        	
                System.out.println("Geben sie das erste Land ein [ANGREIFER];");
                input = br.readLine();
                String land1 = input;
                //Einheiten zum Test der Methode manuel auf 1 setzen
                for(int i = 0; i < sw.getKontinentArray().length ; i++){
                    for(int j= 0; j < sw.getKontinentArray()[i].getLaenderArray().length; j++){
         
         
                        if(input.equals(sw.getKontinentArray()[i].getLaenderArray()[j].getName())){
                        	sw.getKontinentArray()[i].getLaenderArray()[j].setEinheiten(2);
                        }
                    }
            	
                }
                String input1 = input;   
                System.out.println("Geben sie das zweite Land ein [VERTEIDIGER];");
                input = br.readLine();
                String land2 = input;
                sw.laenderNachbarUeberpruefen(input1, input);
                System.out.println("Die SpielerNr vom angreifer ? [1,2,3,4] ? ");
                input = br.readLine();
                int spielerNr = Integer.parseInt(input);
                System.out.println("Die SpielerNr vom angreifer ? [1,2,3,4] ? ");
                input = br.readLine();
                int spielerNr2 = Integer.parseInt(input);
                sw.einAeinV(spielerNr, spielerNr2, land1,land2);
            }
            if(input.equals("randomTest")){
                /*System.out.println("Spieler [?]");
                int input1 = Integer.parseInt(getInputLine());
                System.out.println("Spieler [?]");
                int input2 = Integer.parseInt(getInputLine());*/
                ww.dreiAzweiV();
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
        ww = new Wuerfel();
         
    }
}
     
