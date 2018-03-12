package Aqua_Doctor.listener;

import Aqua_Doctor.ressource.Daten;
import Aqua_Doctor.tools.BitTool;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.komponenten.RE_CheckBox;
import de.Rollmann.komponenten.RE_ComboBox;
import de.Rollmann.komponenten.RE_Slider;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.BitSet;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LiveSlilistener
  implements ChangeListener, MouseListener
{
  public Daten cfg;
  public RE_ComboBox cboStatus;
  public RE_CheckBox chkBox;
  public ComTabelle tab;
  public byte b;
  public BitSet bs;
  public BitSet bs2;
  public int[] array;
  public boolean mouse = false;
  public boolean control = false;
  Thread t;
  
  public LiveSlilistener(RE_ComboBox combo, Daten c, ComTabelle ct, RE_CheckBox check)
  {
    tab = ct;
    cfg = c;
    cboStatus = combo;
    chkBox = check;
  }
  
  public void mouseClicked(MouseEvent e) {}
  
  public void mousePressed(MouseEvent e) {}
  
  public void mouseReleased(MouseEvent e)
  {
    setzeWert(e.getSource());
    mouse = false;
  }
  
  public void mouseEntered(MouseEvent e)
  {
    mouse = true;
  }
  
  public void mouseExited(MouseEvent e)
  {
    mouse = false;
  }
  
  public void stateChanged(ChangeEvent e) {}
  
  public void setzeWert(Object obj)
  {
    RE_Slider slider = (RE_Slider)obj;
    if ((cfg.LUEFTER_MANUELL_AUTO[cfg.LUEFTER_AUSWAHL] == 0) && 
      (cboStatus.getSelectedIndex() == 2) && (slider.isVisible()) && (chkBox.isSelected()))
    {
      b = 63;
      
      bs = BitTool.fromByte(b);
      bs2 = BitTool.fromByte((byte)0);
      
      array = 
        new int[] {
        250, 250, 250, 250, 250, 250, b };
      
      bs.clear(6);
      bs.clear(7);
      
      b = BitTool.toByte(bs);
      if (cfg.LUEFTER_MAN_SPANNUNG[cfg.LUEFTER_AUSWAHL] != false)
      {
        cfg.LUEFTER_MANUELL_SPANNUNG[cfg.LUEFTER_AUSWAHL] = 
          slider.getValue();
        array[cfg.LUEFTER_AUSWAHL] = slider.getValue();
      }
      else
      {
        cfg.LUEFTER_MANUELL_DREHZAHL[cfg.LUEFTER_AUSWAHL] = 
          slider.getValue();
        
        cfg.schreibeDrehzahlWerte(tab, cfg.LUEFTER_AUSWAHL);
        bs2.set(cfg.LUEFTER_AUSWAHL);
      }
      b = BitTool.toByte(bs2);
      array[6] = b;
      try
      {
        tab.setzeSchreiben(ComTabelle.getAdresse(1, true, false), array);
        tab.starteRamSchreiben();
      }
      catch (Exception e) {}
    }
  }
}

