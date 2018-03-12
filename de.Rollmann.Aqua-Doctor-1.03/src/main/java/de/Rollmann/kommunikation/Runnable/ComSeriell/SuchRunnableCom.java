package de.Rollmann.kommunikation.Runnable.ComSeriell;

import de.Rollmann.kommunikation.REComDaten;
import de.Rollmann.kommunikation.REComSeriell;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.EmpfangRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.SendeRunnable;
import purejavacomm.SerialPort;
/**
 * <p>Überschrift: RE-Com</p>
 *
 * <p>Beschreibung: Rollmann Elektronik Powerbus</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Organisation: Rollmann Elektronik</p>
 *
 * @author Manuel Krispin
 * @version 1.0
 */

public class SuchRunnableCom
  extends ControllRunnable
{
	
  private static final int SENDEN = 0;
  private static final int WARTEN = 1;
  private static final int AUFLOESEN = 2;
  private static final int MASTERERSTELLEN = 3;
  
  public SendeRunnable send = null;
  public EmpfangRunnable empfang = null;
  private int zustand = 0;
  private byte suchCounter = 0;
  private SerialPort serialPort;
  private REComSeriell steuer;
  
 
  public SuchRunnableCom(SerialPort sPort, REComSeriell s)
  {
    steuer = s;
    serialPort = sPort;
    try
    {
      Thread t = new Thread(this);
      t.start();
    }
    catch (Exception e) {}
  }
//synchronized
  public void run()
  {
    try
    {
      send = new SendeRunnableCom(serialPort, this);
      empfang = new EmpfangRunnableCom(serialPort, this);
    }
    catch (Exception ex3)
    {
      ende = true;
    }
    while (!ende) {
      try
      {
    	 
        switch (zustand)
        {
        case SENDEN: 
          send.Write(REComDaten.suchFrame);
          
          suchCounter = ((byte)(suchCounter + 1));
          
          wait(1000);
          if (FrameGesendet) {
            zustand = WARTEN;
          } else {
            ende = true;
          }
          break;
        case WARTEN: 
          if (FrameEmpfangen) {
            zustand = MASTERERSTELLEN;
          } else if (suchCounter < 1) {
            zustand = SENDEN;
          } else {
            zustand = AUFLOESEN;
          }
          break;
        case MASTERERSTELLEN: 
          steuer.gefunden(empfang, send);
          
          ende = true;
          
          break;
        case AUFLOESEN: 
          try
          {
            send.beenden();
            empfang.beenden();
            serialPort.close();
            while ((!send.beendet) || (!empfang.beendet)) {}
          }
          catch (Exception e) {}
          ende = true;
          break;
        default: 
          wait(1000);
        }
      }
      catch (InterruptedException ex)
      {
        try
        {
          serialPort.close();
        }
        catch (Exception e) {}
        ende = true;
        
        send.beenden();
        empfang.beenden();
        while ((!send.beendet) || (!empfang.beendet)) {}
      }
      catch (Exception ex2)
      {
        ende = true;
      }
    }
    steuer.meldeEnde(this);
    beendet = true;
  }
  /**
   * Method invoked when the given thread terminates due to the given
   * uncaught exception.
   *
   * @param t the thread
   * @param e the exception
   * @todo Diese java.lang.Thread.UncaughtExceptionHandler-Methode
   *   implementieren
   */
  public void uncaughtException(Thread t, Throwable e) {}
//synchronized
  public synchronized void gesendet()
  {
    FrameGesendet = true;
    notify();
  }
//synchronized
  public synchronized void empfangen(int[] frame)
  {
    if (frame[7] == 83)
    {
      FrameEmpfangen = true;
      notify();
    }
  }
  
  public boolean queueFrame(int[] Adresse, int Ziel, int[] Daten, boolean schreiben)
  {
    return false;
  }
}
