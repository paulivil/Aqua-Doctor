package de.Rollmann.kommunikation.Runnable.Abstrakt;

import Aqua_Doctor.GUI.Dynwache;
import de.Rollmann.kommunikation.Fifo;
import purejavacomm.SerialPort;

import java.io.InputStream;
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

public abstract class EmpfangRunnable
  extends StandardRunnable 
{
  protected Fifo fifo;
  protected InputStream inputStream = null;
  protected ControllRunnable src = null;
  
  public abstract void setControllRunnable(ControllRunnable cr);
  
  public abstract void setWache(Dynwache wache);
  
 
  public abstract String getInterface()
    throws Exception;
  
  public abstract SerialPort getComPort();
  
  public void uncaughtException(Thread t, Throwable e) {}
}