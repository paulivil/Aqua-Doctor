package de.Rollmann.tools;

import java.lang.reflect.Method;

public class SortArray
{
  public static void sort(Object[][] array, int sortierspalte, boolean aufsteigend)
  {
    int len = array.length;
    if ((len > 0) && (sortierspalte >= 0))
    {
      Method compareMethode = getCompareMethod(array[0][sortierspalte]);
      if (compareMethode != null)
      {
        int dim = array[0].length;
        boolean geaendert;
        do
        {
          geaendert = false;
          for (int i = 0; i < len - 1; i++) {
            if (tauschen(array, i, sortierspalte, aufsteigend, 
              compareMethode)) {
              geaendert = true;
            }
          }
        } while (
        
          geaendert);
      }
    }
  }
  
  static Method getCompareMethod(Object o)
  {
    Class<?>[] param = new Class[1];
    param[0] = o.getClass();
    Method m;
    try
    {
      m = o.getClass().getMethod("compareTo", param);
    }
    catch (Exception ex)
    {
     
      return null;
    }
    
    return m;
  }
  
  static boolean tauschen(Object[][] array, int zeile, int sortierspalte, boolean aufsteigend, Method compareMethode)
  {
    boolean tauschenIstNotwendig = false;
    Object[] arrVglObj = new Object[1];
    
    Object[][] tempZeile = new Object[1][array[0].length];
    
    Object o1 = array[zeile][sortierspalte];
    arrVglObj[0] = array[(zeile + 1)][sortierspalte];
    Object ergebnisObjekt = null;
    Integer ergebnis = new Integer(0);
    try
    {
      ergebnisObjekt = compareMethode.invoke(o1, arrVglObj);
      ergebnis = (Integer)ergebnisObjekt;
    }
    catch (Exception e) {}
    if (aufsteigend)
    {
      if (ergebnis.intValue() > 0) {
        tauschenIstNotwendig = true;
      }
    }
    else if (ergebnis.intValue() < 0) {
      tauschenIstNotwendig = true;
    }
    if (tauschenIstNotwendig)
    {
      tempZeile[0] = array[zeile];
      array[zeile] = array[(zeile + 1)];
      array[(zeile + 1)] = tempZeile[0];
    }
    return tauschenIstNotwendig;
  }
}

