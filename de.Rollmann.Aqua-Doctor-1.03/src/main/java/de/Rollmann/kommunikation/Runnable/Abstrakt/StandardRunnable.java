package de.Rollmann.kommunikation.Runnable.Abstrakt;

public abstract class StandardRunnable
  implements Runnable, Thread.UncaughtExceptionHandler
{
  public Thread t;
  public static boolean ende = false;
  public boolean beendet = false;
  
  public abstract void run();
  
  public abstract void uncaughtException(Thread t, Throwable e);
  
  public synchronized boolean beenden()
  {
    ende = true;
    try
    {
      notify();
    }
    catch (Exception e) {}
    while (!beendet) {}
    return true;
  }
}
