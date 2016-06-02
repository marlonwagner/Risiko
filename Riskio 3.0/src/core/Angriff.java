package core;

import java.util.Random;

import ris.local.valueobjects.Wuerfel.Wuerfel;

public class Angriff extends Wuerfel {
  public Angriff(int amntOfDice, int [] arrayA){
    super(amntOfDice, arrayA);
    this.amntOfDice = amntOfDice;
    this.arrayA = arrayA;
  }
  
  public void dice()  { 
    Random rndgen = new Random();
    System.out.println("Angreifer");
    int array [] = new int [amntOfDice];
    for (int i=0;i<amntOfDice ;i++ ) {              
      int erg =1 + rndgen.nextInt(6);
      array[i] = erg; 
    }
    sort(array);
  }

  public static int []  sort (int arrayA[]){
    for (int d = 1;d < arrayA.length;d++) {
      for (int v = 0;v< (arrayA.length - d);v++) {
        if (arrayA[v]<arrayA[v+1]) {
          int help = 0;
          help = arrayA[v];
          arrayA[v] = arrayA[v+1];
          arrayA[v+1] = help;
        } // end of if
      } // end of for    
    }
    arrayPrint(arrayA); 
    setArrayA(arrayA);
    return (arrayA);
  }
} // end of class Angriff