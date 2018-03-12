package de.Rollmann.kommunikation.Runnable.Abstrakt;

import Aqua_Doctor.GUI.Dynwache;
import java.io.OutputStream;

public abstract class SendeRunnable
  extends StandardRunnable
{
  protected OutputStream outputStream = null;
  protected ControllRunnable src = null;
  
  public abstract boolean Write(int[] messageString)
    throws Error, Exception;
  
  public abstract void setWache(Dynwache wache);
  
  public abstract void setControllRunnable(ControllRunnable cr);
  
  public void uncaughtException(Thread t, Throwable e) {}
}
