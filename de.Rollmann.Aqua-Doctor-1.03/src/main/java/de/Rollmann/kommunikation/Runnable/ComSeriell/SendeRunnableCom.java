package de.Rollmann.kommunikation.Runnable.ComSeriell;

import Aqua_Doctor.GUI.Dynwache;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.SendeRunnable;
import de.Rollmann.kommunikation.Seriell;
import de.Rollmann.tools.Konverter;
import purejavacomm.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class SendeRunnableCom
  extends SendeRunnable
{
  private SerialPort serialPort = null;
  private Dynwache w;
  
  public SendeRunnableCom(SerialPort serialPort, ControllRunnable cr)
  {
    src = cr;
    this.serialPort = serialPort;
    try
    {
      outputStream = Seriell.getOutputStream(serialPort);
    }
    catch (IOException e)
    {
      ende = true;
    }
    Thread t = new Thread(this);
    t.start();
  }
  
  public void setControllRunnable(ControllRunnable cr)
  {
    src = cr;
  }
//synchronized
  public synchronized boolean Write(int[] messageString)
    throws Exception, Error
  {
    serialPort.getInputStream().skip(0);
    byte[] ba = Konverter.intArrayTobyteArray(messageString);
    try
    {
      outputStream.write(ba);
      try
      {
        w.resetCounter();
      }
      catch (Exception e) {}
      src.gesendet();
    }
    catch (Exception e) {}
    return true;
  }
//synchronized
  public  synchronized void run()
  {
    while (!ende) {
      try
      {
        wait(10);
      }
      catch (InterruptedException e)
      {
        try
        {
          outputStream.close();
        }
        catch (IOException ex) {}
        ende = true;
      }
    }
    try
    {
      outputStream.close();
    }
    catch (IOException e) {}
    beendet = true;
  }
  
  public void setWache(Dynwache wache)
  {
    w = wache;
  }
}
