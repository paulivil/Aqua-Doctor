package Aqua_Doctor.kommunikation;

import Aqua_Doctor.GUI.MainFrame;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;

public class DynThread
  implements Runnable
{
  boolean ende = false;
  //Thread t;
  MainFrame mFrame;
  
  public DynThread(MainFrame frame)
  {
    mFrame = frame;
    Thread t = new Thread(this);
    t.setName("DynThread");
    t.start();
  }
//synchronized
  public  boolean beenden()
  {
    ende = true;
    notify();
    
    return true;
  }
//synchronized
  public  void run()
  {
    while (!ende)
    {
      mFrame.tabcom.setzeLesen(ComTabelle.getAdresse(1, true, false));
      mFrame.tabcom.setzeLesen(ComTabelle.getAdresse(2, true, false));
      mFrame.tabcom.setzeLesen(ComTabelle.getAdresse(3, true, false));
      mFrame.tabcom.setzeLesen(ComTabelle.getAdresse(4, true, false));
      mFrame.tabcom.setzeLesen(ComTabelle.getAdresse(5, true, false));
      try
      {
        if (mFrame.tabcom.master.Zustand == 0)
        {
          mFrame.tabcom.starteRamLesen();
          
          mFrame.daten.setArray301(
            mFrame.tabcom.getDataRam(ComTabelle.getAdresse(1, true, false)));
          mFrame.daten.setArray302(
            mFrame.tabcom.getDataRam(ComTabelle.getAdresse(2, true, false)));
          mFrame.daten.setArray303(
            mFrame.tabcom.getDataRam(ComTabelle.getAdresse(3, true, false)));
          mFrame.daten.setArray304(
            mFrame.tabcom.getDataRam(ComTabelle.getAdresse(4, true, false)));
          mFrame.daten.setArray305(
            mFrame.tabcom.getDataRam(ComTabelle.getAdresse(5, true, false)));
          
          mFrame.daten.aktualisiere();
        }
        if (mFrame.comUnterbrochen) {
          ende = true;
        } else {
          wait(1000 * mFrame.cfg.ALLGEMEIN_ABFRAGE_INTERVALL);
        }
      }
      catch (Exception ex1)
      {
    	  
        ende = true;
        mFrame.kommunikationUnterbrochen();
        mFrame.stoppeKommunikation(true);
      }
    }
  }
}
