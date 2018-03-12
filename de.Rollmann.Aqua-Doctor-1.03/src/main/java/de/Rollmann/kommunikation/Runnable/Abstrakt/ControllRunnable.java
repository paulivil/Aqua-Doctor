package de.Rollmann.kommunikation.Runnable.Abstrakt;

public abstract class ControllRunnable
  extends StandardRunnable
{
  protected boolean FrameGesendet = false;
  protected boolean FrameEmpfangen = false;
  
  public void uncaughtException(Thread t, Throwable e) {}
  
  public abstract boolean queueFrame(int[] Adresse, int Ziel, int[] Daten, boolean schreiben);
  
  public abstract void gesendet();
  
  public abstract void empfangen(int[] frame);
}
