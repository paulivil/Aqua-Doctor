package de.Rollmann.kommunikation.Runnable.Ethernet;

import Aqua_Doctor.GUI.Dynwache;
import de.Rollmann.kommunikation.Fifo;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.EmpfangRunnable;
import purejavacomm.SerialPort;

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

public class EmpfangRunnableEnet
  extends EmpfangRunnable
{
  private int SocketPort;
  
  public EmpfangRunnableEnet(ThreadGroup tg)
  {
    SocketPort = 61002;
    fifo = new Fifo(20);
    this.src = src;
    
    Thread t = new Thread(this);
    t.setName("Empfang");
    t.start();
  }
  
  public EmpfangRunnableEnet(ThreadGroup tg, int Port)
  {
    SocketPort = Port;
    fifo = new Fifo(20);
    src = this.src;
    
    Thread t = new Thread(this);
    t.setName("Empfang");
    t.start();
  }
//synchronized
  public void run()
  {
    Socket s = null;
    try
    {
      s = new Socket(InetAddress.getLocalHost().getHostAddress(), SocketPort);
      
      inputStream = s.getInputStream();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      ende = true;
    }
    try
    {
      do
      {
        wait(10);
        try
        {
          while (inputStream.available() > 0)
          {
            fifo.in(inputStream.read());
            if (fifo.isFrame()) {
              src.empfangen(fifo.getFrame());
            } else if (fifo.isKeepalive()) {
              s.getOutputStream().write(fifo.getWert(7));
            }
          }
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
      } while (!ende);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
      ende = true;
    }
    try
    {
      inputStream.close();
      inputStream = null;
    }
    catch (Exception e)
    {
    	
      e.printStackTrace();
      
    }
    try
    {
      s.close();
      s = null;
    }
    catch (Exception e) {}
    beendet = true;
  }
  
  public void setControllRunnable(ControllRunnable cr)
  {
    src = cr;
  }
  
  public String getInterface()
  {
    return "";
  }
  
  public void setWache(Dynwache wache) {}
  
  public SerialPort getComPort()
  {
    return null;
  }
}
