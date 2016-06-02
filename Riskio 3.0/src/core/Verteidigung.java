package core;

import java.util.Random;

import risikoklassen.Würfel;

public class Verteidigung extends Wuerfel {
  public Verteidigung( int arrayV[], int amntOfDice){
    super(arrayV, amntOfDice);
    this.amntOfDice = amntOfDice;
    this.arrayV = arrayV;
  }
  
  /**
  * Methode die anhand der Anzahl der Würfel
  * Zufallszahlen ausgibt
  **/
  public void dice()  { 
      Random rndgen = new Random();
      System.out.println("Verteidiger");
      int array [] = new int [amntOfDice];
      for (int i=0;i<amntOfDice ;i++ ) {              
        int erg =1 + rndgen.nextInt(6);
        array[i] = erg;  
      }
      sort(array);
  }
   
   /**
    Methode zum Sortieren eines Arrays
    mittels Bubblesort
    **/
  public static int []  sort (int arrayV[]){
    for (int d = 1;d < arrayV.length;d++) {
      for (int v = 0;v< (arrayV.length - d);v++) {
        if (arrayV[v]<arrayV[v+1]) {
          int help = 0;
          help = arrayV[v];
          arrayV[v] = arrayV[v+1];
          arrayV[v+1] = help;
        } // end of if
      } // end of for    
    }
    arrayPrint(arrayV); 
    setArrayV(arrayV);
    return (arrayV);
  }
} // end of class