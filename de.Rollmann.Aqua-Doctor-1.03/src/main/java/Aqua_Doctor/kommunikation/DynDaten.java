package Aqua_Doctor.kommunikation;

import Aqua_Doctor.GUI.panels.WertePanel;
import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import java.util.Calendar;
import java.util.Locale;

public class DynDaten
{
  public int[] Array301;
  public int[] Array302;
  public int[] Array303;
  public int[] Array304;
  public int[] Array305;
  public int[] array = new int[22];
  public int[] arraySicher = new int[16];
  public boolean kalibrierung = false;
  public int[] LuefterKali = new int[6];
  public Daten cfg;
  public Sprache spr;
  public WertePanel wPanel;
  public Calendar cal = Calendar.getInstance(Locale.GERMAN);
  public boolean ende;
  public boolean beendet;
  public final int FILTER = 3;
  private int[] filterCount = new int[16];
  
  public DynDaten(Daten c, Sprache s, WertePanel w)
  {
    spr = s;
    cfg = c;
    wPanel = w;
  }
  
  public int[] makeArray()
  {
    array[0] = getInt(Array301[6], Array301[7]);
    array[1] = getInt(Array301[8], Array301[9]);
    array[2] = getInt(Array302[0], Array302[1]);
    array[3] = getInt(Array302[2], Array302[3]);
    array[4] = getInt(Array302[4], Array302[5]);
    array[5] = getInt(Array302[6], Array302[7]);
    for (int i = 0; i < 6; i++) {
      if ((array[i] >= arraySicher[i] + 100) || 
        (array[i] <= arraySicher[i] - 100))
      {
        if (filterCount[i] >= 3)
        {
          filterCount[i] = 0;
          arraySicher[i] = array[i];
        }
        else
        {
          filterCount[i] += 1;
          array[i] = arraySicher[i];
        }
      }
      else
      {
        arraySicher[i] = array[i];
        filterCount[i] = 0;
      }
    }
    array[6] = getInt(Array303[4], Array303[5]);
    array[7] = getInt(Array303[6], Array303[7]);
    array[8] = getInt(Array303[8], Array303[9]);
    array[9] = getInt(Array304[0], Array304[1]);
    array[10] = getInt(Array304[2], Array304[3]);
    array[11] = getInt(Array304[4], Array304[5]);
    for (int i = 6; i < 12; i++) {
      if ((array[i] >= 10000) || (array[i] == 0))
      {
        if (filterCount[i] >= 3)
        {
          filterCount[i] = 0;
        }
        else
        {
          if ((arraySicher[i] < 10000) && (arraySicher[i] != 0)) {
            array[i] = arraySicher[i];
          } else {
            array[i] = 1210;
          }
          filterCount[i] += 1;
        }
      }
      else
      {
        arraySicher[i] = array[i];
        filterCount[i] = 0;
      }
    }
    array[12] = getInt(Array302[8], Array302[9]);
    array[13] = getInt(Array303[0], Array303[1]);
    array[14] = getInt(Array303[2], Array303[3]);
    for (int i = 12; i < 14; i++) {
      if ((array[i] >= arraySicher[i] + 100) || 
        (array[i] <= arraySicher[i] - 100))
      {
        if (filterCount[i] >= 3)
        {
          filterCount[i] = 0;
          arraySicher[i] = array[i];
        }
        else
        {
          filterCount[i] += 1;
          array[i] = arraySicher[i];
        }
      }
      else
      {
        arraySicher[i] = array[i];
        filterCount[i] = 0;
      }
    }
    array[15] = Array304[6];
    if ((array[15] >= arraySicher[15] + 20) || 
      (array[15] <= arraySicher[15] - 20))
    {
      if (filterCount[15] >= 3)
      {
        filterCount[15] = 0;
        arraySicher[15] = array[15];
      }
      else
      {
        filterCount[15] += 1;
        array[15] = arraySicher[15];
      }
    }
    else
    {
      arraySicher[15] = array[15];
      filterCount[15] = 0;
    }
    array[16] = Array301[0];
    array[17] = Array301[1];
    array[18] = Array301[2];
    array[19] = Array301[3];
    array[20] = Array301[4];
    array[21] = Array301[5];
    
    return array;
  }
  
  public void luefterPWM()
  {
    for (int i = 0; i < 6; i++) {
      LuefterKali[i] = Array301[i];
    }
  }
  
  public int getInt(int High, int Low)
  {
    return High * 256 + Low;
  }
  
  public void showWarnungen()
  {
    String Fehler = "";
    String Quelle = "";
    
    int fehler = 0;
    int quelle = 0;
    
    fehler = Array305[0];
    quelle = Array305[1];
    
    wPanel.setzeFehlerLabel("");
    switch (quelle)
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      try
      {
        Quelle = cfg.LUEFTER_NAME[quelle];
      }
      catch (Exception e) {}
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      try
      {
        Quelle = cfg.SENSOR_NAME[(quelle - 6)];
      }
      catch (Exception e) {}
    case 12: 
    case 13: 
    case 14: 
      try
      {
        Quelle = cfg.WASSERFLUSS_NAME[(quelle - 12)];
      }
      catch (Exception e) {}
    case 15: 
      try
      {
        Quelle = cfg.WASSERSTAND_NAME;
      }
      catch (Exception e) {}
    }
    switch (fehler)
    {
    case 0: 
      
    case 1: 
      wPanel.setzeFehlerLabel("'" + Quelle + 
        spr.WARNUNG_HAT_STUMMEN_ALARM_AUSGELOEST);
      break;
    case 2: 
      Fehler = spr.WARNUNG;
      wPanel.setzeFehlerLabel("'" + Quelle + 
        spr.WARNUNG_HAT_DEN_WARNWERT_ERREICHT);
      break;
    case 3: 
      Fehler = spr.ALARM;
      wPanel.setzeFehlerLabel("'" + Quelle + 
        spr.WARNUNG_HAT_DEN_ALARMWERT_ERREICHT);
      break;
    case 4: 
      Fehler = spr.NOT_AUS;
      wPanel.setzeFehlerLabel("'" + Quelle + 
        spr.WARNUNG_HAT_DEN_NOTAUSWERT_ERREICHT);
    }
  }
  
  public Calendar getDatum()
  {
    cal.set(1, Array305[3] + 2000);
    cal.set(2, Array305[4] - 1);
    cal.set(5, Array305[5]);
    cal.set(11, Array305[7]);
    cal.set(12, Array305[8]);
    cal.set(13, Array305[9]);
    return cal;
  }
  
  public void aktualisiere()
  {
    try
    {
      wPanel.aktualisiere(makeArray());
      if (kalibrierung) {
        luefterPWM();
      }
      showWarnungen();
    }
    catch (Exception e) {}
  }
  
  public void setArray301(int[] array)
  {
    Array301 = array;
  }
  
  public void setArray302(int[] array)
  {
    Array302 = array;
  }
  
  public void setArray303(int[] array)
  {
    Array303 = array;
  }
  
  public void setArray304(int[] array)
  {
    Array304 = array;
  }
  
  public void setArray305(int[] array)
  {
    Array305 = array;
  }
}
