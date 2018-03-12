package de.Rollmann.tools;

public class Formatter
{
  public static String formatSekunde_zu_StdMinSec(int wert)
  {
    String str = new String("");
    String Einheit = new String(" m");
    if (wert == 0) {
      return "0:00 m";
    }
    if (wert >= 3600)
    {
      int std = wert / 3600;
      wert -= std * 3600;
      str = String.valueOf(std) + ":";
      Einheit = " h";
    }
    int min = wert / 60;
    int sec = wert % 60;
    
    String minute = String.valueOf(min);
    String sekunde = String.valueOf(sec);
    if (sec < 10) {
      sekunde = "0" + sekunde;
    }
    if (min < 10) {
      minute = "0" + minute;
    }
    str = 
      str + minute + ":" + sekunde + Einheit;
    
    return str;
  }
  
  public static String formatMinSec(int wert)
  {
    if (wert > 59)
    {
      int min = wert / 60;
      int sec = wert % 60;
      if (sec < 10) {
        return 
        
          String.valueOf(min) + ":" + "0" + String.valueOf(sec) + " m";
      }
      return 
        String.valueOf(min) + ":" + String.valueOf(sec) + " m";
    }
    return String.valueOf(wert) + " sec";
  }
  
  public static String formatStdMin(int wert)
  {
    if (wert > 59)
    {
      int std = wert / 60;
      int min = wert % 60;
      if (min < 10) {
        return 
        
          String.valueOf(std) + ":" + "0" + String.valueOf(min) + " h";
      }
      return 
        String.valueOf(std) + ":" + String.valueOf(min) + " h";
    }
    return String.valueOf(wert) + " min";
  }
  
  public static String formatLiter(int wert)
  {
    if (wert > 999)
    {
      int liter = wert / 1000;
      int ml = wert % 1000;
      if (ml < 100) {
        return String.valueOf(liter) + ",0 l";
      }
      return 
      
        String.valueOf(liter) + "," + String.valueOf(ml / 100) + " l";
    }
    return String.valueOf(wert) + " ml";
  }
}
