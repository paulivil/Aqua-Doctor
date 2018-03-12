package de.Rollmann.tools;

import java.text.DecimalFormat;
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
  public static final byte CELSIUS = 0;
  public static final byte KELVIN = 1;
  public static final byte FAHRENHEIT = 2;
  
  public static float convertTemp(float Temp, byte tempEinheit)
  {
    switch (tempEinheit)
    {
 
    case CELSIUS: 
      return Temp;
    case KELVIN: 
      return Temp + 273.0F;
    case FAHRENHEIT: 
      return Temp = Temp * 9.0F / 5.0F + 32.0F;
    }
    return Temp;
  }
  
  public static String convertTempToString(float Temp, byte tempEinheit)
  {
    DecimalFormat df = new DecimalFormat("##0.0");
    
    String str = df.format(Temp);
    switch (tempEinheit)
    {
    case CELSIUS: 
      return str;
    case KELVIN: 
      return df.format(Temp + 273.0F);
    case FAHRENHEIT: 
      return df.format(Temp = Temp * 9.0F / 5.0F + 32.0F);
    }
    return str;
  }
  
  public static float convertTemp(float Temp, int Einheit, boolean nurEinheit)
  {
    switch (Einheit)
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
  
  public static int convertDurchfluß(int rpm, int Einheit, int Faktor)
  {
    switch (Einheit)
    {
    case 0: 
      return rpm;
    case 1 : 
      double e = rpm / Faktor * 60.0D;
      
      return (int)e;
    case 2: 
      double f = rpm / Faktor / 3.785D * 60.0D;
      
      return (int)f;
    case 3: 
      double g = rpm / Faktor / 4.3546D * 60.0D;
      
      return (int)g;
    }
    return rpm;
  }
  
  public static String convertTempHalbgrad(float Temp)
  {
    DecimalFormat df = new DecimalFormat("##0.0");
    
    String str = df.format(Temp);
    
    String[] sarray = str.split(",");
    
    int x = Integer.parseInt(sarray[0]);
    int y = Integer.parseInt(sarray[1]);
    if ((y == 1) || (y == 2)) {
      return df.format(x);
    }
    if ((y >= 3) && (y <= 7))
    {
      String s = Integer.toString(x) + ".5";
      return df.format(Float.parseFloat(s));
    }
    if ((y == 8) || (y == 9))
    {
      x++;
      return df.format(x);
    }
    return df.format(Temp);
  }
}
