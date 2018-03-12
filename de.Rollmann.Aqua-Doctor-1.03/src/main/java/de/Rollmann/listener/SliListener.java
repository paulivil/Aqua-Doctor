package de.Rollmann.listener;

import de.Rollmann.komponenten.RE_Slider;
import de.Rollmann.tools.Formatter;
import de.Rollmann.tools.UmrechnungTool;
import java.text.DecimalFormat;
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
  public static final int CELSIUS_GANZZAHL = 15;
  public static final int KELVIN = 16;
  public static final int KELVIN_GANZZAHL = 17;
  public static final int CELSIUS_SCHRITTWEISE = 18;
  public static final int SPANNUNG_FLOAT = 19;
  public static final int SPANNUNG_GANZ = 20;
  
  private boolean bol = false;
  private boolean init = false;
  private boolean immerInit = false;
  private boolean rev = false;
  private boolean autoErh = false;
  public boolean neueDrehzahlen = true;
  private int wert;
private int art;
SliListener Art (int art){
	 this.art = art;
	return null;
}
public   int getArt(int i) {
	 return this.art;
}
  private int max;
  private int min;
  private int prozent;
  private String Einheit;
  private JLabel label;
  private JSlider slider;
  private JSlider slider2;
  private JSlider slider3;
  private JProgressBar pBar;
  public int maxDrehWert;
  public int minDrehWert;
  private DecimalFormat df = new DecimalFormat("###0.0");
  
  public SliListener() {}
  
  public SliListener(JLabel l, int a, int Max, int Min, boolean init)
  {
    max = Max;
    min = Min;
    label = l;
    art = a;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, JSlider sli, int Max, int Min, boolean init, boolean reverse)
  {
    max = Max;
    min = Min;
    label = l;
    art = a;
    slider2 = sli;
    bol = true;
    immerInit = init;
    rev = reverse;
  }
  
  public SliListener(JLabel l, int a, JSlider sli, JSlider sliErh, int Max, int Min, int Prozent, boolean init, boolean reverse, boolean autoErhoehen)
  {
    max = Max;
    min = Min;
    label = l;
    art = a;
    slider2 = sli;
    bol = true;
    immerInit = init;
    rev = reverse;
    prozent = Prozent;
    autoErh = autoErhoehen;
    slider3 = sliErh;
  }
  
  public SliListener(JLabel l, int a, String s, int Max, int Min, boolean init)
  {
    max = Max;
    min = Min;
    label = l;
    art = a;
    Einheit = s;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, int Max, int Min, int MaxAnzeigeWert, int MinAnzeigeWert, boolean init)
  {
    max = Max;
    min = Min;
    
    minDrehWert = MinAnzeigeWert;
    maxDrehWert = MaxAnzeigeWert;
    
    label = l;
    art = a;
    immerInit = init;
  }
  
  public SliListener(JLabel l, int a, RE_Slider sli, int Max, int Min, int MaxAnzeigeWert, int MinAnzeigeWert, boolean init)
  {
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
  
  public SliListener(JLabel l, int a, JProgressBar p, int Max, int Min, boolean init)
  {
    max = Max;
    min = Min;
    label = l;
    art = a;
    pBar = p;
    immerInit = init;
  }
  
  public void setzeMinimum(int min)
  {
    slider.getModel().setMinimum(min);
  }
  
  public void setzeMaximum(int max)
  {
    slider.setMaximum(max);
  }
  
  private void setzeLabelCelsius()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    float temp = UmrechnungTool.convertTemp(wert / 10.0F, 
      (byte)0);
    
    label.setText(String.valueOf(temp) + " °C");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelKelvin()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    float temp = UmrechnungTool.convertTemp(wert / 10.0F, 
      (byte)0);
    
    label.setText(String.valueOf(temp) + " K");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelKelvinGanz()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    label.setText(String.valueOf(wert) + " K");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelCelsiusGanz()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    label.setText(String.valueOf(wert) + " �C");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelCelsiusSchritt()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    wert = (wert / 5 * 5);
    
    float temp = UmrechnungTool.convertTemp(wert / 10.0F, 
      (byte)0);
    label.setText(String.valueOf(temp) + " �C");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelProzent()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert) + " %");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabel()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert));
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelDrehzahl()
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
  
  private void setzeLabelSpannung()
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
  
  private void setzeLabelSpannungFloat()
  {
    float spannung = wert / 10.0F;
    
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(df.format(spannung)) + " V");
    try
    {
      if (bol) {
        slider2.getModel().setMinimum(wert + 1);
      }
    }
    catch (Exception e) {}
    if (autoErh)
    {
      float hilf = slider3.getValue();
      hilf *= prozent;
      hilf /= 100.0F;
      
      slider.setMaximum(slider3.getValue() + (int)hilf);
    }
  }
  
  private void setzeLabelSpannungGanz()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert) + " V");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelEinheit()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    label.setText(String.valueOf(wert) + " " + Einheit);
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelLiter()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    label.setText(Formatter.formatLiter(wert));
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelZeitStdMin()
  {
    label.setText(Formatter.formatStdMin(wert));
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelZeitStdMinSec()
  {
    label.setText(Formatter.formatSekunde_zu_StdMinSec(wert));
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelZeitMinSec()
  {
    label.setText(Formatter.formatMinSec(wert));
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
  }
  
  private void setzeLabelProzentUmrechnung()
  {
    label.setHorizontalTextPosition(4);
    label.setHorizontalAlignment(4);
    
    int prozent = 100 * wert / 255;
    
    label.setText(String.valueOf(prozent) + " %");
    if (bol) {
      slider2.getModel().setMinimum(wert + 1);
    }
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
      case CELSIUS_GANZZAHL: 
        setzeLabelCelsiusGanz();
        break;
      case KELVIN: 
        setzeLabelKelvin();
        break;
      case KELVIN_GANZZAHL: 
        setzeLabelKelvinGanz();
        break;
      case CELSIUS_SCHRITTWEISE: 
        setzeLabelCelsiusSchritt();
        break;
      case SPANNUNG_FLOAT: 
        setzeLabelSpannungFloat();
        break;
      case SPANNUNG_GANZ: 
        setzeLabelSpannungGanz();
		default:
			break;
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
