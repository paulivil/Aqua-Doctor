package Aqua_Doctor.kommunikation;

import Aqua_Doctor.dialoge.Abstract.DialogAquaFortschritt;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;
import de.Rollmann.komponenten.RE_ComFrame;
/**
 * <p>Überschrift: RE_Tools</p>
 *
 * <p>Beschreibung: Verschieden Tools</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */
public class TabelleAqua_Doctor
  extends ComTabelle
  implements Runnable
{
  public DialogAquaFortschritt dialog;
  public int aktion = 0;
  
  public TabelleAqua_Doctor(MasterRunnable mr, RE_ComFrame frame)
  {
    comFrame = frame;
    
    master = mr;
    
    ADRESSE_EXTERN_START = 40;
    EXTERN_ANZAHL = 0;
    
    ADRESSE_RAM_START = 301;
    EEPROM_ANZAHL = 300;
    RAM_ANZAHL = 6;
    
    EEProm = new int[EEPROM_ANZAHL][11];
    
    Ram = new int[RAM_ANZAHL][11];
    
    master.starteMaster(this);
    
    Thread t = new Thread(this);
    t.start();
  }
  
  public void uncaughtException(Thread t, Throwable e) {}
}
