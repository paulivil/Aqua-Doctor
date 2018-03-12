package de.Rollmann.kommunikation.Daten;

import de.Rollmann.kommunikation.ComTabellen.ComTabelle;

public class Aufbereitung
{
 

public static void schreibeName(String str, ComTabelle tab, int Adresse, int Zelle, int Laenge)
  {
    char[] c1 = str.toCharArray();
    int x = c1.length;
    
    int[] hilf = new int[Laenge];
    for (int i = 0; i < Laenge; i++)
    {
      if (i < x) {
        hilf[i] = convertCharForController(c1[i]);
      } else {
        hilf[i] = 32;
      }
      if (Zelle >= 9)
      {
        Adresse++;
        Zelle = 0;
      }
      else
      {
        Zelle++;
      }
    }
  }
  
  public static String leseName(int[] Name)
  {
    int x = Name.length;
    
    String s = new String();
    
    char[] c1 = new char[x];
    for (int i = 0; i < x; i++) {
      c1[i] = convertCharForPC(Name[i]);
    }
    s = new String(c1);
    
    return s;
  }
  
  public static int[][] schreibeNamen(String[] str, int Laenge)
  {
    int[] hilf = new int[Laenge * str.length];
    for (int i = 0; i < str.length; i++)
    {
      char[] c1 = str[i].toCharArray();
      int x = c1.length;
      for (int j = 0; j < Laenge; j++) {
        if (j < x) {
          hilf[(j + i * Laenge)] = convertCharForController(c1[j]);
        } else {
          hilf[(j + i * Laenge)] = 32;
        }
      }
    }
    int x = hilf.length / 10;
    int[][] name;
      if (hilf.length % 10 > 0) {
      name = new int[x + 1][10];
    } else {
      name = new int[x][10];
    }
    for (int i = 0; i < x; i++) {
      System.arraycopy(hilf, 0 + i * 10, name[i], 0, 10);
    }
    if (hilf.length % 10 > 0) {
      System.arraycopy(hilf, 0 + x * 10, name[x], 0, 
        hilf.length % 10);
    }
    return name;
  }
  
  public static String[] leseNamen(int Adresse, int Zelle, int Anzahl, int Laenge, ComTabelle tab)
  {
    int x = Anzahl * Laenge;
    String[] namen = new String[Anzahl];
    
    int[] y = new int[x];
    char[] c1 = new char[x];
    
    int ZaehlerStart = 0;
    if (Zelle > 0) {
      ZaehlerStart = 1;
    }
    for (int i = ZaehlerStart; i < (x + Zelle) / 10; i++) {}
   // ((x + Zelle) % 10);
    for (int i = 0; i < x; i++) {
      c1[i] = convertCharForPC(y[i]);
    }
    for (int i = 0; i < Anzahl; i++) {
      namen[i] = String.copyValueOf(c1, 0 + i * Laenge, Laenge);
    }
    return namen;
  }
  
  
  public static int convertCharForController(char c)
  {
    switch (c)
    {
    case '\u00fc': 
      c = 129;
      break;
    case '\u00e4': 
      c = 132;
      break;
    case '\u00f6': 
      c = 148;
      break;
    case '\u00dc': 
      c = 153;
      break;
    case '\u00d6': 
      c = 153;
      break;
    case '\u00c4': 
      c = 142;
    }
    return c;
  }
  
  public static char convertCharForPC(int x)
  {
	    
	    char c;
   
    switch (x)
    {
    case 129: 
      c = '\u00fc';
      break;
    case 132: 
      c = '\u00e4';
      break;
    case 148: 
      c = '\u00f6';
      break;
    case 142: 
      c = '\u00c4';
      break;
    case 153: 
      c = '\u00d6';
      break;
    case 154: 
      c = '\u00dc';
      break;
    default: 
      c = (char)x;
    }
    return (char)x;
  }
}