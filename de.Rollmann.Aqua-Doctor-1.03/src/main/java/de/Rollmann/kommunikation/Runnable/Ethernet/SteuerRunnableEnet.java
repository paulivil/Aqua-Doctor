package de.Rollmann.kommunikation.Runnable.Ethernet;

import de.Rollmann.kommunikation.REComDaten;
import de.Rollmann.kommunikation.REComFrame;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.SteuerKlasse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SteuerRunnableEnet
  extends ControllRunnable
{
  public static final int STANDBY = 0;
  public static final int INIT = 1;
  public static final int SENDEN = 2;
  public static final int VERGLEICHEN = 3;
  public static final byte ALIVE = 11;
  public static final byte SUCHEN = 99;
  public static final byte ENDE = 100;
  private OutputStream out = null;
  private InputStream in = null;
  private Socket s = null;
  public int Zustand = 0;
  private int sendeCounter = 0;
  private ThreadGroup stg;
  private SteuerKlasse steuer;
  private int i = 0;
  private int x = 0;
  private ArrayList<REComFrame> SendeQueue = new ArrayList<REComFrame>();
  public SteuerRunnableEnet()
    throws Exception
  {}
//synchronized
  public  boolean Write(int befehl)
    throws Error, Exception
  {
    out.write(befehl);
    return false;
  }
//synchronized
  public  void run()
  {
    while (!ende) {
      switch (Zustand)
      {
      case STANDBY: 
        try
        {
          if (SendeQueue.size() > 0) {
            Zustand = SENDEN;
          }
          wait(1000);
        }
        catch (InterruptedException ex)
        {
          ende = true;
        }
      case INIT: 
        for (int i = 0; i < 10; i++) {
          try
          {
            wait(1000);
          }
          catch (InterruptedException e) {}
        }
        break;
      case SENDEN: 
        FrameGesendet = false;
        
        sendeCounter = 0;
        Zustand = 0;
      }
    }
    try
    {
      out.close();
      in.close();
      s.close();
    }
    catch (Exception e) {}
    out = null;
    in = null;
    s = null;
    
    System.gc();
    
    beendet = true;
  }
  
  public boolean queueFrame(int[] Adresse, int Ziel, int[] Daten, boolean schreiben)
  {
    if (schreiben) {
      SendeQueue.add(new REComFrame(REComDaten.getSchreibenFrame(
        Adresse, 
        Ziel, Daten)));
    } else {
      SendeQueue.add(new REComFrame(
        REComDaten.getLeseFrame(Adresse, Ziel)));
    }
    return false;
  }
  
  public void gesendet()
  {
    FrameGesendet = true;
  }
  
  public void empfangen(int[] frame)
  {
    FrameEmpfangen = true;
  }
  
  class SuchThread
    implements Runnable
  {
    //private Thread t;
    private boolean ende = false;
    
    public SuchThread()
    {
      Thread t = new Thread();
      t.start();
    }
    
    public void run()
    {
      File f = new File(".\\Bridge\\");
      try
      {
        String[] play = {
          "cmd", "/c", "start", 
          "RE_Com_Bridge.exe" };
        
        ProcessBuilder pc = new ProcessBuilder(play);
        pc.directory(f);
        Process p = pc.start();
        
        wait(2000);
      }
      catch (IOException e)
      {
        ende = true;
      }
      catch (InterruptedException e)
      {
        ende = true;
      }
      while ((ende = false) != false)
      {
        for (int i = 0; i < 10; i++)
        {
          try
          {
            s = new Socket(InetAddress.getLocalHost().getHostAddress(), 
              61000);
            out = s.getOutputStream();
            in = s.getInputStream();
          }
          catch (UnknownHostException e) {}catch (IOException e) {}
          try
          {
            wait(1000);
          }
          catch (InterruptedException e) {}
        }
        int x = 0;
        while (!ende)
        {
          try
          {
            out.write(SUCHEN);
          }
          catch (Exception e) {}
          try
          {
            while (in.available() > 0)
            {
              x = in.read();
              wait(10);
            }
          }
          catch (IOException e) {}catch (InterruptedException e) {}
          if (x == SUCHEN) {
            ende = true;
          }
        }
        try
        {
          s.close();
        }
        catch (Exception e) {}
        try
        {
          in.close();
        }
        catch (Exception e) {}
        try
        {
          out.close();
        }
        catch (Exception e) {}
      }
    }
  }
}