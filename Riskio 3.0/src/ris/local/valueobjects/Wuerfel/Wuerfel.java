package ris.local.valueobjects.Wuerfel;

import java.util.Random;
public class Wuerfel {
  static int amntOfDice;
  static int arrayA[];
  static int arrayV[];
  
    
  public Wuerfel(int amnt, int []arrayA) {   
    this.amntOfDice = amnt;
    this.arrayA = arrayA;
  }
  
  
  public Wuerfel( int []arrayV, int amnt) {
    this.amntOfDice = amnt;
    this.arrayV = arrayV;
  }  
  /**  
  public static int []  sort (int array[]){
    for (int d = 1;d < array.length;d++) {
      for (int v = 0;v< (array.length - d);v++) {
        if (array[v]<array[v+1]) {
          int help = 0;
          help = array[v];
          array[v] = array[v+1];
          array[v+1] = help;
        } // end of if
      } // end of for    
    }
    arrayPrint(array); 
    
    return (array);
    
  }  **/
    
  public static void compare (int arrayA[], int arrayV[]){
    arrayA = arrayA;
    arrayV = arrayV;
    int attPoint = 0;
    int defPoint = 0;
    for (int i = 0;i<arrayV.length ;i++ ) {
      if (arrayA[i]>arrayV[i]) {
        attPoint++;
      } else{
        defPoint++;
      }  // end of if-else
    }// end of for
    
    if (attPoint == 2) {
      System.out.println("Angreifer gewinnt"
      +"\n"+"Verteidiger verliert 2 Einheiten");
      
    } else if((attPoint == 1) && (defPoint == 1) ) {
      System.out.println("Unentschieden"
      +"\n"+"Angreifer und Verteidiger verlieren eine Einheit");
      
    } else if (defPoint == 2){
      System.out.println("Verteidiger gewinnt"
      +"\n"+"Angreifer verliert 2 Einheiten");
    } else if((attPoint == 0) && (defPoint == 1)){
      System.out.println("Verteidiger gewinnt");
    } else if ((attPoint == 1) && (defPoint == 0)) {
      System.out.println("Angreifer Gewinnt");
    }
  }
  
  public static int getAmntOfDice(){
    return amntOfDice;
  }

  public static void setAmntOfDice(int amntOfDice){
    amntOfDice = amntOfDice;
  }

  public static  void setArrayA(int[] array)  {
    arrayA = array;
    
  }
  public static void setArrayV(int [] array){
    arrayV = array;
    
  }

  public static void arrayPrint(int array[]){
    for (int i=0;i<array.length ;i++ ) {
      System.out.println(array[i]);
      
    } // end of for
    System.out.println("===========================");
  }
}   