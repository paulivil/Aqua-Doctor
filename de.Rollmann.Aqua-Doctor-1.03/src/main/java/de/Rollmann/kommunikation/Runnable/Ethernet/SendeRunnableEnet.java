package de.Rollmann.kommunikation.Runnable.Ethernet;

import Aqua_Doctor.GUI.Dynwache;
import de.Rollmann.kommunikation.Fifo;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.SendeRunnable;
import de.Rollmann.tools.Konverter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
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
public class SendeRunnableEnet
  extends SendeRunnable
{
  Fifo fifo = new Fifo(20);
  private int SocketPort;
  
  public SendeRunnableEnet(ThreadGroup tg)
  {
    SocketPort = 61001;
    Thread t = new Thread(this);
    t.setName("Sender");
    t.start();
  }
  
  public SendeRunnableEnet(ThreadGroup tg, int Port)
  {
    SocketPort = Port;
    t = new Thread(this);
    t.setName("Sender");
    t.start();
  }
  /**
   * Write
   *
   * @param messageString int[]
   * @return boolean
   * @throws Error
   * 
   */
//synchronized
  public boolean Write(int[] messageString)
    throws Error, Exception
  {
    byte[] ba = Konverter.intArrayTobyteArray(messageString);
    
    outputStream.write(ba);
    src.gesendet();
    
    return false;
  }
//synchronized
  public  void run()
  {
    Socket s = null;
    try
    {
      s = new Socket(InetAddress.getLocalHost().getHostAddress(), SocketPort);
      
      outputStream = s.getOutputStream();
    }
    catch (Exception ex3)
    {
      ende = true;
      
      ex3.printStackTrace();
     
    }
    while (!ende) {
      try
      {
        wait(10);
      }
      catch (InterruptedException ex)
      {
        try
        {
          outputStream.close();
        }
        catch (IOException e) {}
        ende = true;
      }
      catch (Exception e) {}catch (Error e) {}
    }
    try
    {
      outputStream = null;
    }
    catch (Exception e) {}
    try
    {
      s = null;
    }
    catch (Exception e) {}
    beendet = true;
  }
  
  public void setControllRunnable(ControllRunnable cr)
  {
    src = cr;
  }
  
  public void setWache(Dynwache wache) {}
}
