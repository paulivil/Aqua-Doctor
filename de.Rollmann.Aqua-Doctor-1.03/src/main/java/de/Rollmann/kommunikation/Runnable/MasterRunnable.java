package de.Rollmann.kommunikation.Runnable;

import java.util.ArrayList;

import Aqua_Doctor.GUI.Dynwache;
import de.Rollmann.kommunikation.ComTabellen.ComTabelle;
import de.Rollmann.kommunikation.REComDaten;
import de.Rollmann.kommunikation.REComFrame;
import de.Rollmann.kommunikation.Runnable.Abstrakt.ControllRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.EmpfangRunnable;
import de.Rollmann.kommunikation.Runnable.Abstrakt.SendeRunnable;

public class MasterRunnable
extends ControllRunnable
{

public static final int STANDBY = 0;
  public static final int INIT = 1;
  public static final int SENDEN = 2;
  public static final int VERGLEICHEN = 3;
  public SendeRunnable send = null;
  public EmpfangRunnable empfang = null;
  public int Zustand = STANDBY;
  public int VZustand = STANDBY;
  private int sendeCounter = 0;
  Dynwache w;
  private static ThreadGroup stg;
  private int i = 0;
  private int x = 0;
  public ComTabelle tabCom;
  private int[] lastSend = new int[3];
  /*private REComArrayList<REComFrame> SendeQueue = new REComArrayList<REComFrame>(1);
  private REComArrayList<REComFrame> EmpfangQueue = new REComArrayList<REComFrame>(1);
  private REComArrayList<REComFrame> GesendetQueue = new REComArrayList<REComFrame>(1);
  private REComArrayList<REComFrame> UnzugeordnetQueue = new REComArrayList<REComFrame>(1);
  */
  private ArrayList<REComFrame> SendeQueue = new ArrayList<REComFrame>();
  private ArrayList<REComFrame> EmpfangQueue = new ArrayList<REComFrame>();
  private ArrayList<REComFrame> GesendetQueue = new ArrayList<REComFrame>();
  private ArrayList<REComFrame> UnzugeordnetQueue = new ArrayList<REComFrame>();
  public MasterRunnable(EmpfangRunnable er, SendeRunnable sr, ThreadGroup tg)
  {
    stg = tg;
    
    empfang = er;
    send = sr;
    
    empfang.setControllRunnable(this);
    send.setControllRunnable(this);
  }
//synchronized
  public synchronized void starteDatenuebertragung()
  {
    if (Zustand != SENDEN)
    {
      Zustand = SENDEN;
      notify();
    }
  }
  
  public void starteMaster(ComTabelle tab)
  {
    tabCom = tab;
    try
    {
      Thread t = new Thread(this);
      t.setName("Master");
      t.start();
    }
    catch (Exception e) {}
  }
  
  public String getInterface()
    throws Exception
  {
    return empfang.getInterface();
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
    return true;
  }
//synchronized
  public   void run()
  {
    empfang.setControllRunnable(this);
    send.setControllRunnable(this);
    
    w = new Dynwache(this);
    empfang.setWache(w);
    send.setWache(w);
    while (!ende) {
      switch (Zustand)
      {
      case STANDBY: 
        try
        {
          wait(1000);
        }
        catch (InterruptedException ex)
        {
          ende = true;
        }
      case SENDEN: 
        FrameGesendet = false;
        while (SendeQueue.size() > 0 && !ende)
        {
          FrameEmpfangen = false;
          if (sendeCounter < 30 && !FrameEmpfangen)
          {
            if (sendeCounter >= 2) {
              System.out.println("Pusemuckel");
            }
            if (!send.beendet)
            {
              try
              {
                lastSend = REComDaten.getAdresse(((REComFrame)SendeQueue.get(0)).REFrame);
                
                send.Write(((REComFrame)SendeQueue.get(0)).REFrame);
              }
              catch (Exception ex3)
              {
                tabCom.KommunikationUnterbrochen();
                ende = true;
              }
              catch (Error ex3)
              {
                tabCom.KommunikationUnterbrochen();
                ende = true;
              }
              sendeCounter ++;
            }
            else
            {
              ende = true;
              break;
            }
            try
            {
              wait(3000);
            }
            catch (InterruptedException ex2)
            {
              ende = true;
            }
            if (FrameGesendet && FrameEmpfangen)
            {
              sendeCounter = 0;
              
              SendeQueue.remove(0);
            }
          }
          else
          {
            tabCom.KommunikationUnterbrochen();
            ende = true;
          }
        }
        sendeCounter = 0;
        Zustand = STANDBY;
        break;
      case INIT: 
        try
        {
          initialisiere();
          wait(1000);
          Zustand = SENDEN;
        }
        catch (InterruptedException ex1)
        {
          ende = true;
        }
        catch (Exception ex)
        {
          ende = true;
        }
      }
    }
    try
    {
      w.beenden();
      send.beenden();
      empfang.beenden();
      tabCom.beenden();
    }
    catch (Exception e) {}
    send = null;
    empfang = null;
    
    System.gc();
    
    beendet = true;
  }
  
  public void initialisiere()
    throws Exception
  {
    send.Write(REComDaten.suchFrame);
  }
  
  private void findeSlaves() {}
  
  public void uncaughtException(Thread t, Throwable e) {}
//synchronized
  public synchronized void gesendet()
  {
    FrameGesendet = true;
  }
//synchronized
  public synchronized void empfangen(int[] frame)
  {
    try
    {
      tabCom.empfangen(REComDaten.getAdresse(frame), 
        REComDaten.getDaten(frame), REComDaten.getRW(frame));
    }
    catch (Exception e) {}
    if (lastSend[0] == REComDaten.getAdresse(frame)[0] && 
      lastSend[1] == REComDaten.getAdresse(frame)[1] && 
      lastSend[2] == REComDaten.getAdresse(frame)[2]) {
      FrameEmpfangen = true;
    }
    i ++;
    
    notify();
  }
  class VergleichRunnable
  implements Runnable
  {
  	

  public VergleichRunnable()
  {
    try
    {
      Thread t = new Thread(stg, this);
      t.start();
    }
    catch (Exception e) {}
  }

  private boolean vergleicheFrames(REComFrame frame)
  {
    for (int i = 0; i < GesendetQueue.size(); i++) {
      if (frame.vergleichen(((REComFrame)GesendetQueue.get(i)).REFrame))
      {
        GesendetQueue.remove(i);
        return true;
      }
    }
    frame.geprueft ++;
    
    return false;
  }
//synchronized
  public  void run()
  {
    while (!ende) {
      switch (VZustand)
      {
      case STANDBY: 
        try
        {
          wait(1000);
        }
        catch (InterruptedException e) {}
      case VERGLEICHEN:
      	int i = 0;
      	while (EmpfangQueue.size() > 0)
     	 {
     	for  (; i  < EmpfangQueue.size(); i++)
     	 
           {
         i = 0; continue;
           }
     	
         if (((REComFrame)EmpfangQueue.get(i)).geprueft < 10)
            {
           if (vergleicheFrames((REComFrame)EmpfangQueue.get(i)))
             {
             EmpfangQueue.remove(i);
             i = 0;
                     
             }
              else
              {
                EmpfangQueue.add(EmpfangQueue.get(i));
                EmpfangQueue.remove(i);
              }
            }
            else
            {
              UnzugeordnetQueue.add(EmpfangQueue.get(i));
              EmpfangQueue.remove(i);
            }
           } 
          
          VZustand = 0;
          break;   	 
        case INIT: 
        case SENDEN: 
        default: 
          VZustand = 0;
     	    }
         }
       }
      }
 
}