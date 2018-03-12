package de.Rollmann.kommunikation.Runnable.ComSeriell;

import Aqua_Doctor.GUI.Dynwache;
import de.Rollmann.kommunikation.Fifo;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.EmpfangRunnable;
import purejavacomm.SerialPort;
import purejavacomm.SerialPortEvent;
import purejavacomm.SerialPortEventListener;
import de.Rollmann.kommunikation.Seriell;
import java.io.IOException;
import java.util.TooManyListenersException;




public class EmpfangRunnableCom
  extends EmpfangRunnable
  implements  SerialPortEventListener
{
	
  private SerialPort serialPort = null;
 
  private int x = 0;
  private Dynwache w;
  
  
  public EmpfangRunnableCom(SerialPort sp, ControllRunnable src)
  {
    fifo = new Fifo(20);
    this.src = src;
    serialPort = sp;
    
    sp.notifyOnCTS(true);
    sp.notifyOnBreakInterrupt(true);
    sp.notifyOnCarrierDetect(true);
    sp.notifyOnDSR(true);
    
    Thread t = new Thread(this);
    t.setName("Empfang");
    t.start();
  }
  
  public void setControllRunnable(ControllRunnable cr)
  {
    src = cr;
  }
//synchronized
  public synchronized void run()
  {
    try
    {
    
    	     serialPort.addEventListener(this);
           inputStream = Seriell.getInputStream(serialPort);
    }
    catch (IOException e)
    {
      ende = true;
    }
    catch (TooManyListenersException e)
    {
      ende = true;
    }
    /*Beginn der Hauptschleife*/
    while (!ende) {
      try
      {
        wait(1);
      }
      catch (InterruptedException e)
      {
        ende = true;
      }
    }
    try
    {
      serialPort.notifyOnDataAvailable(false);
    }
    catch (Exception e) {}
    try
    {
      inputStream.close();
    }
    catch (IOException e) {}
    try
    {
      serialPort.close();
    }
    catch (Exception e) {}
    beendet = true;
  }
  
  private void checkFrame(byte b[])
  {
    fifo.setFrame(b);
  }
  
 
		  
  public String getInterface()
    throws Exception
  {
    return serialPort.getName();
  }
  
 

public void serialEvent(SerialPortEvent e)
  {
    try
    {
      switch (e.getEventType())
      {
      case SerialPortEvent.BI: 
        break;
      case SerialPortEvent.OE: 
        break;
      case SerialPortEvent.FE: 
        break;
      case SerialPortEvent.PE: 
        break;
      case SerialPortEvent.CD:
      case SerialPortEvent.CTS:
      case SerialPortEvent.DSR:
      case SerialPortEvent.RI:
      case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
          break;
      case SerialPortEvent.DATA_AVAILABLE:
        boolean bol = false;
        try
        {
          do
          {
            fifo.in(inputStream.read());
            inputStream.mark(0);
            if (fifo.isFrame())
            {
              if (inputStream.available() > 0) {
                inputStream.skip(inputStream.available());
              }
              int[] frame = fifo.getFrame();
              fifo.in(255);
              try
              {
                w.resetCounter();
              }
              catch (Exception e1) {}
              src.empfangen(frame);
            }
            if (inputStream.available() <= 0) {
              break;
            }
          } while (!ende);
        }
        catch (IOException e1) {}catch (NullPointerException e1) {}
      }
    }
    catch (Error e1) {}catch (Exception e1) {}
  }
  
  public void setWache(Dynwache wache)
  {
    w = wache;
  }
  
  public SerialPort getComPort()
  {
    return serialPort;
  }
}
