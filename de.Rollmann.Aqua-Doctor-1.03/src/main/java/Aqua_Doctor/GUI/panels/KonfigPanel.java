package Aqua_Doctor.GUI.panels;

import Aqua_Doctor.ressource.Daten;
import javax.swing.JPanel;

public abstract class KonfigPanel
  extends JPanel
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 5760671886139099714L;
public boolean ladenAktiv = false;
  
  public abstract void ladeKonfig();
  
  public abstract void setzeKonfig(Daten c);
  
  public abstract void ladeEinstellung();
  
  public abstract void ladeStandardEinstellung();
  
  public abstract void setzeEinstellung();
  
  public abstract void speicherEinstellung();
  
  public abstract void setzeSprache();
  
  public abstract void setzeListener();
  
  public abstract void fuelleCombo();
  
  public abstract void aktualisiere();
  
  public abstract void removeListener();
}