package Aqua_Doctor.tools;

import Aqua_Doctor.ressource.Daten;
/**
 * <p>Überschrift: HeatMaster</p>
 *
 * <p>Beschreibung: PC-Oberflaeche fuer HeatMaster</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */

public class UmrechnungTool

{
	
  public static float convertTemp(float Temp, Daten cfg, boolean nurEinheit)
  {
	  
    switch (cfg.ALLGEMEIN_TEMP_EINHEIT)
    {
    case 0: 
      return Temp;
    case 1: 
      if (nurEinheit) {
        return Temp;
      }
      float kelvin = 273.15F;
      
      return Temp + kelvin;
    case 2: 
      if (nurEinheit) {
        return Temp;
      }
      return Temp = Temp * 9.0F / 5.0F + 32.0F;
    }
    return Temp;
  }
  
  public static int convertDurchfluß(int rpm, int sensor, Daten cfg)
  {
    switch (cfg.WASSERFLUSS_SENSOR_EINHEIT[sensor])
    {
    case 0: 
      return rpm;
    case 1: 
      double e = rpm / 
        cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[sensor] * 60.0D;
      
      return (int)e;
    case 2: 
      double f = rpm / 
        cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[sensor] / 3.785D * 60.0D;
      
      return (int)f;
    case 3: 
      double g = rpm / 
        cfg.WASSERFLUSS_SENSOR_EINHEIT_FAKTOR[sensor] / 4.3546D * 60.0D;
      
      return (int)g;
    }
    return rpm;
  }
}

