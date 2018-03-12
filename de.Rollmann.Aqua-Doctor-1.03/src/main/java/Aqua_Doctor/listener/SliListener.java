package Aqua_Doctor.listener;

import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.ressource.Sprache;
import Aqua_Doctor.tools.UmrechnungTool;
import de.Rollmann.komponenten.RE_Slider;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliListener
implements ChangeListener
{
	
	
	
	public static final int ZEITMINSEC = 1;
	  public static final int CELSIUS = 2;
	  public static final int PROZENT = 3;
	  public static final int NORMAL = 4;
	  public static final int DREHZAHL = 5;
	  public static final int SPANNUNG = 6;
	  public static final int EINHEIT = 7;
	  public static final int LITER = 8;
	  public static final int ZEITSTDMIN = 9;
	  public static final int ZEITSTDMINSEC = 10;
	  public static final int PROZENT_UMRECHNUNG = 11;
	  public static final int DREHZAHL_UMRECHNUNG = 12;
	  public static final int KORREKTUR_WERT = 13;
	  public static final int VARIABEL = 14;
	  public static final int VARIABEL_COMBO = 15;
	
  public boolean bol = false;
  public boolean init = false;
  public boolean immerInit = false;
  public boolean rev = false;
  public boolean zeigeTempHys = false;
  public boolean neueDrehzahlen = true;
  public int wert;
  public int art; 	
  public int max;
  public int min;
  public String Einheit;
  public JLabel label;
  public JSlider slider;
  public JSlider slider2;
  public JProgressBar pBar;
  public int maxDrehWert;
  public int minDrehWert;
  public Sprache spr;
  public Daten cfg;
  public JComboBox<?> combo;
  public DecimalFormat df = new DecimalFormat("###0.0");
  
  public SliListener(Sprache s, Daten c)
  {
    spr = s;
    cfg = c;
  }
  
  public SliListener(JLabel l, int a, int Max, int Min, boolean init, Sprache s, Daten c)
  {
    spr = s;
    cfg = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, int Max, int Min, boolean init, Sprache s, Daten c, boolean zeigeCelsius)
  {
    spr = s;
    cfg = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    immerInit = init;
    zeigeTempHys = zeigeCelsius;
  }
  
  public SliListener(JLabel l, int a, int Max, int Min, boolean init, Sprache s, JComboBox<?> c)
  {
    spr = s;
    combo = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, JSlider sli, int Max, int Min, boolean init, boolean reverse, Sprache s, Daten c)
  {
    spr = s;
    cfg = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    slider2 = sli;
    bol = true;
    immerInit = init;
    rev = reverse;
  }
  
  public SliListener(JLabel l, int a, JSlider sli, int Max, int Min, boolean init, boolean reverse, Sprache s, JComboBox<?> c)
  {
    spr = s;
    combo = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    slider2 = sli;
    bol = true;
    immerInit = init;
    rev = reverse;
  }
  
  public SliListener(JLabel l, int a, String s, int Max, int Min, boolean init, Sprache sp, Daten c)
  {
    spr = sp;
    cfg = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    Einheit = s;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, int Max, int Min, int MaxAnzeigeWert, int MinAnzeigeWert, boolean init, Sprache s, Daten c)
  {
    spr = s;
    cfg = c;
    max = Max;
    min = Min;
    minDrehWert = MinAnzeigeWert;
    maxDrehWert = MaxAnzeigeWert;
    label = l;
    art = a;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, RE_Slider sli, int Max, int Min, int MaxAnzeigeWert, int MinAnzeigeWert, boolean init, Sprache s, Daten c)
  {
    spr = s;
    cfg = c;
    max = Max;
    min = Min;
    minDrehWert = MinAnzeigeWert;
    maxDrehWert = MaxAnzeigeWert;
    label = l;
    art = a;
    slider2 = sli;
    bol = true;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, JProgressBar p, int Max, int Min, boolean init, Sprache s, Daten c)
  {
    spr = s;
    cfg = c;
    max = Max;
    min = Min;
    label = l;
    art = a;
    pBar = p;
    immerInit = init;
  }
  
  public void setzeLabelZeitMinSec()
  {
    label.setHorizontalAlignment(4);
    if (wert > 59)
    {
      int min = wert / 60;
      int sec = wert % 60;
      if (sec < 10) {
        label.setText(String.valueOf(min) + ":" + "0" + String.valueOf(sec) + 
          " " + spr.EINHEIT_MINUTE);
      } else {
        label.setText(String.valueOf(min) + ":" + String.valueOf(sec) + 
          " " + spr.EINHEIT_MINUTE);
      }
    }
    else
    {
      label.setText(String.valueOf(wert) + " " + spr.EINHEIT_SEKUNDE);
    }
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelCelsius()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    float temp = UmrechnungTool.convertTemp(wert / 10.0F, cfg, 
      zeigeTempHys);
    
    label.setText(String.valueOf(temp) + " " + 
      spr.EINHEIT_TEMPERATUR);
    if ((cfg.ALLGEMEIN_TEMP_EINHEIT == 1) && (zeigeTempHys)) {
      wert += 273;
    }
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelProzent()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert) + " %");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabel()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert));
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelDrehzahl()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert + " RPM"));
    if (bol) {
      if (rev) {
        slider2.setMaximum(wert - 1);
      } else {
        slider2.getModel().setMinimum(wert + 1);
      }
    }
  }
  
  public void setzeLabelSpannung()
  {
    float spannung = wert * 12.0F / 200.0F;
    if (spannung > 12.0F) {
      spannung = 12.0F;
    }
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(df.format(spannung)) + " V");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelEinheit()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert) + " " + Einheit);
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelLiter()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    if (wert > 999)
    {
      int liter = wert / 1000;
      int ml = wert % 1000;
      if (ml < 100) {
        label.setText(String.valueOf(liter) + ",0 l");
      } else {
        label.setText(String.valueOf(liter) + "," + String.valueOf(ml / 100) + 
          " l");
      }
    }
    else
    {
      label.setText(String.valueOf(wert) + " ml");
    }
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelZeitStdMin()
  {
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelZeitStdMinSec()
  {
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelProzentUmrechnung()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    int prozent = 100 * wert / 255;
    
    label.setText(String.valueOf(prozent) + " %");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  public void setzeLabelDrehzahlUmrechnung()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
    float drehzahl = cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] + 
      (cfg.LUEFTER_MAXLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL] - 
      cfg.LUEFTER_MINLUEFTER_DREHZAHL[cfg.LUEFTER_AUSWAHL]) * (
      wert / 200.0F);
    
    label.setText(String.valueOf((int)drehzahl) + " " + spr.EINHEIT_UMDREHUNG);
  }
  
  public void setzeLabelKorrekturWert()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    if (wert == 100)
    {
      label.setText(String.valueOf(0) + " " + spr.EINHEIT_TEMPERATUR);
    }
    else if (wert > 100)
    {
      float f = (wert - 100) / 10.0F;
      
      label.setText(Float.toString(f) + " " + spr.EINHEIT_TEMPERATUR);
    }
    else if (wert < 100)
    {
      float f = (100 - wert) / 10.0F;
      label.setText("-" + Float.toString(f) + " " + spr.EINHEIT_TEMPERATUR);
    }
  }
  
  public void setzeLabelVariabel()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    switch (cfg.WASSERFLUSS_SENSOR_EINHEIT[cfg.WASSERFLUSS_AUSWAHL])
    {
    case 0: 
      label.setText(String.valueOf(wert) + " " + spr.EINHEIT_UMDREHUNG);
      break;
    case 1: 
      label.setText(String.valueOf(wert) + " " + spr.EINHEIT_LITER_PRO_STUNDE);
      break;
    case 2: 
      label.setText(String.valueOf(wert) + " " + 
        spr.EINHEIT_GALONE_PRO_STUNDE);
      break;
    case 3: 
      label.setText(String.valueOf(wert) + " " + 
        spr.EINHEIT_GALONE_PRO_STUNDE);
    }
    if (bol) {
      if (rev) {
        slider2.setMaximum(wert - 1);
      } else {
        slider2.getModel().setMinimum(wert + 1);
      }
    }
  }
  
  public void setzeLabelVariabelCombo()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    try
    {
      switch (combo.getSelectedIndex())
      {
      case 0: 
        label.setText(String.valueOf(wert) + " " + spr.EINHEIT_UMDREHUNG);
        break;
      case 1: 
        label.setText(String.valueOf(wert) + " " + 
          spr.EINHEIT_LITER_PRO_STUNDE);
        break;
      case 2: 
        label.setText(String.valueOf(wert) + " " + 
          spr.EINHEIT_GALONE_PRO_STUNDE);
        break;
      case 3: 
        label.setText(String.valueOf(wert) + " " + 
          spr.EINHEIT_GALONE_PRO_STUNDE);
      }
      if (bol) {
        if (rev) {
          slider2.setMaximum(wert - 1);
        } else {
          slider2.getModel().setMinimum(wert + 1);
        }
      }
    }
    catch (Exception e) {}
  }
  
  public void stateChanged(ChangeEvent e)
  {
    slider = ((JSlider)e.getSource());
    if (!init)
    {
      slider.getModel().setMinimum(min);
      slider.setMaximum(max);
      init = true;
    }
    if (immerInit)
    {
      slider.getModel().setMinimum(min);
      slider.setMaximum(max);
    }
    wert = slider.getValue();
    try
    {
  
    	 switch (art)
         {
         case ZEITMINSEC: 
             setzeLabelZeitMinSec();
             break;
           case CELSIUS: 
             setzeLabelCelsius();
             break;
           case PROZENT: 
             setzeLabelProzent();
             break;
           case NORMAL: 
             setzeLabel();
             break;
           case DREHZAHL: 
             setzeLabelDrehzahl();
             break;
           case SPANNUNG: 
             setzeLabelSpannung();
             break;
           case EINHEIT: 
             setzeLabelEinheit();
             break;
           case LITER: 
             setzeLabelLiter();
             break;
           case ZEITSTDMIN: 
             setzeLabelZeitStdMin();
             break;
           case ZEITSTDMINSEC: 
             setzeLabelZeitStdMinSec();
             break;
           case PROZENT_UMRECHNUNG: 
             setzeLabelProzentUmrechnung();
             break;
           case DREHZAHL_UMRECHNUNG: 
             setzeLabelDrehzahlUmrechnung();
             break;
           case KORREKTUR_WERT: 
             setzeLabelKorrekturWert();
             break;
           case VARIABEL: 
             setzeLabelVariabel();
             break;
           case VARIABEL_COMBO: 
           setzeLabelVariabelCombo();
      }
      try
      {
        pBar.setValue(wert);
      }
      catch (Exception e1) {}
      return;
    }
    catch (Exception e1) {}
  }
}

