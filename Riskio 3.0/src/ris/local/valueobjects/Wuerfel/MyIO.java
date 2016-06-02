package ris.local.valueobjects.Wuerfel;

import java.io.* ;
import java.text.* ;


/**
  Hilfklasse zur vereinfachten Tastatureingabe.

  Zur einfacheren Verwendung in der Schule führen alle Fehleingaben zum
  sofortigen Programmabbruch, ohne dass Exceptions abgefangen oder behandelt
  werden müssen. Ebenfalls zur vereinfachten Verwendung ist die vorliegende
  Klasse nicht als Package implementiert.
  
  @author Dr. Peter Voigt
  @version v3.7.1 / 2008-10-01
*/
public class MyIO
{
  private BufferedReader br
    = new BufferedReader (new InputStreamReader (System.in)) ;


  /**
    Der Standardkonstruktor ist der einzig verfügbare Konstruktor.
  */
  public MyIO ()
  {

  }

  
  /**
    Tastatureingabe eines Strings (Zeichenkette) ohne Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public String getString ()
  {
    String strValue = null ;
    try
    {
      strValue = br.readLine () ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return strValue ;
  }


  /**
    Tastatureingabe eines Strings (Zeichenkette) mit Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public String getString (String str)
  {
    String strValue = null ;
    System.out.print (str) ;
    try
    {
      strValue = br.readLine () ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return strValue ;
  }


  /**
    Tastatureingabe eines Integer-Wertes ohne Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public int getInt ()
  {
    String intStr = null ;
    int intValue = 0 ;
    try
    {
      intStr = br.readLine () ;
      intValue = Integer.parseInt (intStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"int\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return intValue ;
  }


  /**
    Tastatureingabe eines Integer-Wertes mit Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public int getInt (String str)
  {
    String intStr = null ;
    int intValue = 0 ;
    System.out.print (str) ;
    try
    {
      intStr = br.readLine () ;
      intValue = Integer.parseInt (intStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"int\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return intValue ;
  }


  /**
    Tastatureingabe eines Long-Wertes ohne Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public long getLong ()
  {
    String longStr = null ;
    long longValue = 0 ;
    try
    {
      longStr = br.readLine () ;
      longValue = Long.parseLong (longStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"long\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return longValue ;
  }
  
  
  /**
    Tastatureingabe eines Long-Wertes mit Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public long getLong (String str)
  {
    String longStr = null ;
    long longValue = 0 ;
    System.out.print (str) ;
    try
    {
      longStr = br.readLine () ;
      longValue = Long.parseLong (longStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"long\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return longValue ;
  }


  /**
    Tastatureingabe eines Float-Wertes ohne Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public float getFloat ()
  {
    String floatStr = null ;
    float floatValue = (float)0.0 ;
    try
    {
      floatStr = br.readLine () ;
      floatValue = Float.parseFloat (floatStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"float\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return floatValue ;
  }


  /**
    Tastatureingabe eines Float-Wertes mit Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public float getFloat (String str)
  {
    String floatStr = null ;
    float floatValue = (float)0.0 ;
    System.out.print (str) ;
    try
    {
      floatStr = br.readLine () ;
      floatValue = Float.parseFloat (floatStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"float\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return floatValue ;
  }


  /**
    Tastatureingabe eines Float-Wertes mit Ausgabe von Text an der
    Eingabeaufforderung. Nachkommastellen können wahlweise mit Komma oder Punkt
    abgetrennt werden.
  */
  public float getFloat (String str, boolean convertComma)
  {
    String floatStr = null ;
    float floatValue = (float)0.0 ;
    System.out.print (str) ;
    try
    {
      floatStr = br.readLine () ;
      if (convertComma)
      {
        floatStr = floatStr.replaceAll (",", ".") ;
      }
      floatValue = Float.parseFloat (floatStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"float\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return floatValue ;
  }


  /**
    Tastatureingabe eines Double-Wertes ohne Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public double getDouble ()
  {
    String doubleStr = null ;
    double doubleValue = 0.0 ;
    try
    {
      doubleStr = br.readLine () ;
      doubleValue = Double.parseDouble (doubleStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"double\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return doubleValue ;
  }


  /**
    Tastatureingabe eines Double-Wertes mit Ausgabe von Text an der
    Eingabeaufforderung.
  */
  public double getDouble (String str)
  {
    String doubleStr = null ;
    double doubleValue = 0.0 ;
    System.out.print (str) ;
    try
    {
      doubleStr = br.readLine () ;
      doubleValue = Double.parseDouble (doubleStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"double\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return doubleValue ;
  }


  /**
    Tastatureingabe eines Double-Wertes mit Ausgabe von Text an der
    Eingabeaufforderung. Nachkommastellen können wahlweise mit Komma oder Punkt
    abgetrennt werden.
  */
  public double getDouble (String str, boolean convertComma)
  {
    String doubleStr = null ;
    double doubleValue = 0.0 ;
    System.out.print (str) ;
    try
    {
      doubleStr = br.readLine () ;
      if (convertComma)
      {
        doubleStr = doubleStr.replaceAll (",", ".") ;
      }
      doubleValue = Double.parseDouble (doubleStr) ;
    }
    catch (IOException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: I/O error when reading from keyboard.\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    catch (NumberFormatException e)
    {
      String msg = "ERROR: " + e.getClass ().getName () + ": " + e.getMessage ()
        + "\nERROR: Input string is not of type \"double\".\nProgram aborted." ;
      System.out.println (msg) ;
      System.exit (1) ;
    }
    return doubleValue ;
  }
  
  
  /**
    Umformung eines Double-Wertes in einen String gemäß "formatString". Falls
    das Ausgabeformat als Leer-String übergeben wird, wird zur Konvertierung das
    voreingestellte Format "#00.000" verwendet.
  */
  public String printDouble (double doubleValue, String formatString )
  {
    if (formatString == null) formatString = "#00.000" ;
    if (formatString == "") formatString = "#00.000" ;
    DecimalFormat df = new DecimalFormat (formatString) ;
    return df.format (doubleValue) ;
  }
}

