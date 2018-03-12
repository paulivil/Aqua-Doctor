package Aqua_Doctor.GUI;

import de.Rollmann.kommunikation.Runnable.Abstrakt.StandardRunnable;
import de.Rollmann.kommunikation.Runnable.MasterRunnable;



public class Dynwache
  extends StandardRunnable
{
  int counter = 0;
  int counter2 = 0;
  boolean error = false;
  MasterRunnable master;
  
  public Dynwache(MasterRunnable sp)
  {
    master = sp;
    Thread t = new Thread(this);
    t.setName("DynWache");
    t.start();
  }
//synchronized?
  public void run()
  {
	  
    while (!ende) {
      try
      {
       Thread.sleep(3000);
        if (master.Zustand == 2)
        {
          counter ++;
        }
        else
        {
          counter = 0;
          if (master.Zustand == 0) {
            counter2 ++;
          } else {
            counter2 = 0;
          }
        }
        if (counter > 3)
        {
          ende = true;
          error = true;
        }
        else if (counter2 > 3)
        {
          if ((master.Zustand == 0) && (!ende) && 
            (t.isAlive()))
          {
            master.queueFrame(new int[3], 0, new int[10], false);
            master.starteDatenuebertragung();
          }
          counter2 = 0;
        }
      }
      catch (InterruptedException ex)
      {ex.printStackTrace();
        ende = true;
      }
    }
    if (error) {
      try
      {
        master.tabCom.KommunikationVollUnterbrochen();
      }
      catch (Exception e) {}
    }
    beendet = true;
  }
  
  public void resetCounter()
  {
    counter = 0;
    counter2 = 0;
  }
  
  public void uncaughtException(Thread t, Throwable e) {}
  
  public boolean beenden()
  {
    ende = true;
    while (!beendet) {}
    return true;
  }
}
